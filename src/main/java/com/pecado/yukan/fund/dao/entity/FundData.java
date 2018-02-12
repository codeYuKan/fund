package com.pecado.yukan.fund.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FundData {
    private String code;

    private Date netDate;

    private BigDecimal netAssetValue;

    private BigDecimal netAccumulatedValue;

    private BigDecimal dailyGrowthRate;

    private String subscriptionStatus;

    private String redeemStatus;

    private String dividendDistribution;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getNetDate() {
        return netDate;
    }

    public void setNetDate(Date netDate) {
        this.netDate = netDate;
    }

    public BigDecimal getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(BigDecimal netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public BigDecimal getNetAccumulatedValue() {
        return netAccumulatedValue;
    }

    public void setNetAccumulatedValue(BigDecimal netAccumulatedValue) {
        this.netAccumulatedValue = netAccumulatedValue;
    }

    public BigDecimal getDailyGrowthRate() {
        return dailyGrowthRate;
    }

    public void setDailyGrowthRate(BigDecimal dailyGrowthRate) {
        this.dailyGrowthRate = dailyGrowthRate;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus == null ? null : subscriptionStatus.trim();
    }

    public String getRedeemStatus() {
        return redeemStatus;
    }

    public void setRedeemStatus(String redeemStatus) {
        this.redeemStatus = redeemStatus == null ? null : redeemStatus.trim();
    }

    public String getDividendDistribution() {
        return dividendDistribution;
    }

    public void setDividendDistribution(String dividendDistribution) {
        this.dividendDistribution = dividendDistribution == null ? null : dividendDistribution.trim();
    }
}