package com.example.demo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoldRateScraper {

    public static double getCurrentGoldRate() {
        try {
            // Connect to the gold rate website
            Document doc = Jsoup.connect("https://www.goodreturns.in/gold-rates/coimbatore.html").get();

            // Find the gold price element (usually it's inside table rows)
            Elements elements = doc.select("table.gold_silver_table tr:contains(22 Carat Gold (1 gram)) td");

            if (elements.size() >= 2) {
                String priceText = elements.get(1).text().replaceAll("[^\\d.]", "");
                return Double.parseDouble(priceText);
            } else {
                throw new RuntimeException("Gold rate element not found or format changed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
