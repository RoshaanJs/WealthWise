package com.example.demo.controller;

import com.example.demo.entity.GoldRate;
import com.example.demo.service.GoldRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoldRateController {

    @Autowired
    private GoldRateService goldRateService;

    @GetMapping("/goldrate")
    public String showGoldRate(Model model) {
        GoldRate goldRate = goldRateService.fetchAndSaveTodayRate();
        model.addAttribute("rate", goldRate.getRatePerGram());
        model.addAttribute("date", goldRate.getDate());
        return "goldrate"; // JSP file name
    }
}
