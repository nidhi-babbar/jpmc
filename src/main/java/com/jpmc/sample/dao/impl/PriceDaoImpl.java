package com.jpmc.sample.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmc.sample.dao.PriceDao;
import com.jpmc.sample.dto.AssetPrice;

@Repository
public class PriceDaoImpl implements PriceDao {

    @Override
    public List<AssetPrice> getPrices(List<String> assetIds) {
        List<AssetPrice> prices = new ArrayList<>();
        prices.add(new AssetPrice("S1", 50.5));
        prices.add(new AssetPrice("S2", 20.2));
        prices.add(new AssetPrice("S3", 10.4));
        prices.add(new AssetPrice("S4", 15.5));
        
        List<AssetPrice> result = new ArrayList<>();
        for (String assetId : assetIds) {
            for (AssetPrice asset : prices) {
                if (asset.getAssetId().equals(assetId)) {
                    result.add(asset);
                    break;
                }
            }
        }
        return result;
    }
}