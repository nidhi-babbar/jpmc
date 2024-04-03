package com.jpmc.sample.dto;

import java.util.List;

public class EligibilityRequest {
    private List<String> accountIds;
    private List<String> assetIds;


    public EligibilityRequest() {
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public List<String> getAssetIds() {
        return assetIds;
    }

    public void setAssetIds(List<String> assetIds) {
        this.assetIds = assetIds;
    }
}