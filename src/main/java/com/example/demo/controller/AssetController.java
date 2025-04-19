package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.entity.GoldRate;
import com.example.demo.entity.NewUser;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssetService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


import com.example.demo.service.GoldRateService;


@Controller
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AssetService assetService;

    @Autowired
    private GoldRateService goldRateService;


    @GetMapping("/assets")
    public String showAssets(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail"); // use correct session key
        if (email == null) {
            return "redirect:/login";
        }

        NewUser user = userRepository.findByEmail(email);
        List<Asset> assets = assetRepository.findByUser(user);

        // Calculate totals
        double totalGrams = assets.stream()
                .mapToDouble(Asset::getGrams)
                .sum();

        double totalInvestment = assets.stream()
                .mapToDouble(a -> a.getTotalAmount().doubleValue())
                .sum();

//        double currentGoldRate = fetchCurrentGoldRate(); // from scraper
        GoldRate goldRate = goldRateService.fetchAndSaveTodayRate(); // ✅ Get the object
        double currentGoldRate = goldRate.getRatePerGram();     
        model.addAttribute("rateDate", goldRate.getDate());// ✅ Now get the Date


        double currentValue = totalGrams * currentGoldRate;
        double difference = currentValue - totalInvestment;

        // 💡 Add user name to the model
        model.addAttribute("name", user.getName());

        model.addAttribute("assets", assets);
        model.addAttribute("totalGrams", totalGrams);
        model.addAttribute("totalInvestment", totalInvestment);
        model.addAttribute("currentRate", currentGoldRate);
        model.addAttribute("currentValue", currentValue);
        model.addAttribute("difference", difference);
        model.addAttribute("status", difference >= 0 ? "Profit" : "Loss");
        model.addAttribute("profitOrLoss", Math.abs(difference));


        return "asset";
    }


    @PostMapping("/assets/add")
    public String addAsset(@ModelAttribute Asset asset, HttpSession session) {
    	String email = (String) session.getAttribute("userEmail");
        if (email == null) {
            return "redirect:/login";
        }

        NewUser user = userRepository.findByEmail(email);
        asset.setUser(user);

        // Validate grams field here for safety
        if (asset.getGrams() <= 0) {
            throw new IllegalArgumentException("Grams must be greater than 0");
        }

        BigDecimal totalAmount = BigDecimal.valueOf(asset.getGrams() * asset.getPurchasePricePerGram());
        asset.setTotalAmount(totalAmount);

        assetRepository.save(asset);
        return "redirect:/assets";
    }
    
//    private double fetchCurrentGoldRate() {
//        try {
//            Document doc = Jsoup.connect("https://www.goodreturns.in/gold-rates/coimbatore.html")
//                    .userAgent("Mozilla/5.0") // 👈 this tricks the site into thinking it’s a real browser
//                    .get();
//
//            Elements rows = doc.select(".gold_silver_table tr");
//
//            for (Element row : rows) {
//                if (row.text().contains("22 Carat Gold Rate")) {
//                    String rateText = row.select("td").get(1).text().replace(",", "").replace("₹", "").trim();
//                    return Double.parseDouble(rateText);
//                }
//            }
//        } catch (IOException | NumberFormatException e) {
//            e.printStackTrace();
//        }
//        return 0.0; // fallback
//    }
    @PostMapping("/assets/delete/{id}")
    public String deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id); // Call the service to delete
        return "redirect:/assets"; // Redirect back to refresh the page
    }
}
