package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class GoldRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double ratePerGram;

    @Temporal(TemporalType.DATE)
    private Date date;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRatePerGram() {
        return ratePerGram;
    }

    public void setRatePerGram(double ratePerGram) {
        this.ratePerGram = ratePerGram;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
