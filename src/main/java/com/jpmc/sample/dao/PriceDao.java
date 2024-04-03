package com.jpmc.sample.dao;

import java.util.List;

import com.jpmc.sample.dto.AssetPrice;


public interface PriceDao {
    List<AssetPrice> getPrices(List<String> assetIds);
}