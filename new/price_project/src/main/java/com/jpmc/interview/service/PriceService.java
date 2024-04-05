package com.jpmc.interview.service;

import java.util.List;

import com.jpmc.interview.model.AssetPrice;


public interface PriceService {
    List<AssetPrice> getPricesByAssetIds(List<String> assetIds);
}