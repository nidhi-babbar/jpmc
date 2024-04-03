package com.jpmc.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.interview.dao.PriceDao;
import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {
	
	 @Autowired
	 private PriceDao priceDao;

    @Override
    public List<AssetPrice> getPrices(List<String> assetIds) {
        return priceDao.getPrices(assetIds);
    }
}