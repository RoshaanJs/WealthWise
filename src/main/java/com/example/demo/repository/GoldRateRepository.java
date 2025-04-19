package com.example.demo.repository;

import com.example.demo.entity.GoldRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface GoldRateRepository extends JpaRepository<GoldRate, Long> {
    Optional<GoldRate> findByDate(Date date);
}
