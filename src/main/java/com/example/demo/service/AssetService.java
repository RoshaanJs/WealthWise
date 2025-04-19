package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.NewUser;

import java.math.BigDecimal;
import java.util.List;

public interface AssetService {
    void saveAsset(Asset asset, NewUser user);
    List<Asset> getAssetsByUser(NewUser user);
    BigDecimal getTotalInvestment(List<Asset> assets);
    double getTotalGrams(List<Asset> assets);
//    double fetchCurrentGoldRate();
    
    
    void deleteAsset(Long id);

}
