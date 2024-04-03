package com.jpmc.sample.dto;

import java.math.BigDecimal;

public class AccountCollateral {
    private String accountId;
    private BigDecimal  collateralValue;

    // Constructor, getters, and setters
    public AccountCollateral() {
    }

    public AccountCollateral(String accountId, double  collateralValue) {
        this.accountId = accountId;
        this.collateralValue = BigDecimal.valueOf(collateralValue).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(BigDecimal collateralValue) {
        this.collateralValue = collateralValue.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
}