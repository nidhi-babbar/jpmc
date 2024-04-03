package com.jpmc.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.sample.dao.PriceDao;
import com.jpmc.sample.dto.AssetPrice;
import com.jpmc.sample.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {
	
	 @Autowired
	 private PriceDao priceDao;

    @Override
    public List<AssetPrice> getPrices(List<String> assetIds) {
        return priceDao.getPrices(assetIds);
    }
}