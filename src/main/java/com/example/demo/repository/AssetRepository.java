package com.example.demo.repository;

import com.example.demo.entity.Asset;
import com.example.demo.entity.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByUser(NewUser user);
}
