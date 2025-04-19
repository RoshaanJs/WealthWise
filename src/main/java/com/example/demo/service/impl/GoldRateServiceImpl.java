package com.example.demo.service.impl;

import com.example.demo.entity.GoldRate;
import com.example.demo.repository.GoldRateRepository;
import com.example.demo.service.GoldRateService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Service
public class GoldRateServiceImpl implements GoldRateService {

    @Autowired
    private GoldRateRepository goldRateRepository;
    @Override
    public GoldRate fetchAndSaveTodayRate() {
        try {
            Document doc = Jsoup.connect("https://www.goodreturns.in/gold-rates/coimbatore.html")
                    .userAgent("Mozilla/5.0")
                    .get();

            // Print page title to verify it's loaded
            System.out.println("Page title: " + doc.title());

            Element table = doc.selectFirst("table.table-conatiner");
            if (table != null) {
                Element firstRow = table.selectFirst("tbody.tablebody tr");
                if (firstRow != null) {
                    Elements cols = firstRow.select("td");
                    if (cols.size() >= 2) {
                        String todayRateText = cols.get(1).text().replace("₹", "").replace(",", "").trim();
                        double ratePerGram = Double.parseDouble(todayRateText);

                        GoldRate goldRate = new GoldRate();
                        goldRate.setDate(new Date());
                        goldRate.setRatePerGram(ratePerGram);

                        return goldRateRepository.save(goldRate); // Save and return
                    }
                }
            }

            System.out.println("Gold rate row not found.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Fallback if scraping fails
        GoldRate fallback = new GoldRate();
        fallback.setDate(new Date());
        fallback.setRatePerGram(0.0);
        return goldRateRepository.save(fallback);
    }




    @Override
    public GoldRate getTodayRate() {
        Optional<GoldRate> optional = goldRateRepository.findByDate(new Date());
        return optional.orElseGet(this::fetchAndSaveTodayRate);
    }
}
