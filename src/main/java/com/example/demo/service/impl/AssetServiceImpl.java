package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.NewUser;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public void saveAsset(Asset asset, NewUser user) {
        asset.setUser(user);
        BigDecimal totalAmount = BigDecimal.valueOf(asset.getGrams())
                .multiply(BigDecimal.valueOf(asset.getPurchasePricePerGram()));
        asset.setTotalAmount(totalAmount);
        assetRepository.save(asset);
    }

    @Override
    public List<Asset> getAssetsByUser(NewUser user) {
        return assetRepository.findByUser(user);
    }

    @Override
    public BigDecimal getTotalInvestment(List<Asset> assets) {
        return assets.stream()
                .map(Asset::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public double getTotalGrams(List<Asset> assets) {
        return assets.stream()
                .mapToDouble(Asset::getGrams)
                .sum();
    }

//    @Override
//    public double fetchCurrentGoldRate() {
//        try {
//            Document doc = Jsoup.connect("https://www.goodreturns.in/gold-rates/coimbatore.html").get();
//            Elements rateElement = doc.select(".gold_silver_table tbody tr td:nth-of-type(2)");
//            if (!rateElement.isEmpty()) {
//                String rateText = rateElement.first().text().replace(",", "").trim();
//                return Double.parseDouble(rateText);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0.0;
//    }

    @Override
    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
