package com.example.demo.service;

import com.example.demo.entity.GoldRate;
import java.util.Date;

public interface GoldRateService {
    GoldRate fetchAndSaveTodayRate();
    GoldRate getTodayRate();
}
