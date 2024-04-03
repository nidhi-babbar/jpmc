package com.jpmc.sample.service;

import java.util.List;

import com.jpmc.sample.dto.AssetPrice;


public interface PriceService {
    List<AssetPrice> getPrices(List<String> assetIds);
}