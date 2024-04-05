package com.jpmc.interview.dao;

import java.util.List;

import com.jpmc.interview.model.AssetPrice;


public interface PriceDao {
    List<AssetPrice> getPricesByAssetIds(List<String> assetIds);
}