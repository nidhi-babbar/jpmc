package com.jpmc.interview.dao;

import java.util.List;

import com.jpmc.interview.model.AssetPrice;


public interface PriceDao {
    List<AssetPrice> getPrices(List<String> assetIds);
}