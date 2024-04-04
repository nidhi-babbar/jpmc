package com.jpmc.interview.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.interview.dao.CollateralDao;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.AccountCollateral;
import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.Position;
import com.jpmc.interview.service.CollateralService;
import com.jpmc.interview.service.EligibilityService;
import com.jpmc.interview.service.PositionService;
import com.jpmc.interview.service.PriceService;

@Service
public class CollateralServiceImpl implements CollateralService {

	    @Autowired
	    private PositionService positionService;

	    @Autowired
	    private EligibilityService eligibilityService;

	    @Autowired
	    private PriceService priceService;
	    
	    @Autowired
		 private CollateralDao collateralDao;

	    @Override
	    public List<AccountCollateral> calculateCollateralValue(List<String> accountIds) {
	    	
	       if(accountIds ==null || accountIds.size()==0) {
	    	   throw new NullPointerException("Account id is empty ");
	       }
	    	
	    	List<AccountCollateral> accountCollaterals = new ArrayList<>();
	        List<Account> account = positionService.getPositions(accountIds);
			for(Account acc:account) {
	    
			List<String> assetIds = extractAssetIds(acc.getPositions());
	        List<Eligibility> eligibility = eligibilityService.checkEligibility(accountIds, assetIds);
	     
	        List<AssetPrice> prices = priceService.getPrices(assetIds);
	        double collateralValue = calculateAccountCollateral(acc.getAccountId(), acc.getPositions(), eligibility, prices);
            accountCollaterals.add(collateralDao.calculateCollateralValue(acc.getAccountId(),collateralValue));
				}

	   

	        return accountCollaterals;
	    }

	    private List<String> extractAssetIds(List<Position> positions) {
	        List<String> assetIds = new ArrayList<>();
	        for (Position position : positions) {
	            assetIds.add(position.getAssetId());
	        }
	        return assetIds;
	    }

	    private double calculateAccountCollateral(String accountId, List<Position> positions,
	                                              List<Eligibility> eligibility, List<AssetPrice> prices) {
	        double totalCollateralValue = 0;
	        for (Position position : positions) {
	        
	        	double positionCollateralValue = calculatePositionCollateral( accountId,position, eligibility, prices);
	            totalCollateralValue += positionCollateralValue;
	        }
	        return totalCollateralValue;
	    }

	    private double calculatePositionCollateral(String accountId,Position position, List<Eligibility> eligibility, List<AssetPrice> prices) {
	        double quantity = position.getQuantity();
	        String assetId = position.getAssetId();
	        Eligibility assetEligibility = findEligibility(accountId ,eligibility, assetId);
	        double price = findPrice(prices, assetId);

	        if (assetEligibility != null && price != 0) {
	            if (assetEligibility.isEligible()) {
	                double discount = assetEligibility.getDiscount();
	                return quantity * price * discount;
	            }
	        }

	        return 0;
	    }

	    private Eligibility findEligibility(String accountId,List<Eligibility> eligibility, String assetId) {
	        for (Eligibility assetEligibility : eligibility) {
	        	
	            if (assetEligibility.getAssetIds().contains(assetId)&& assetEligibility.getAccountIds().contains(accountId)) {
	                return assetEligibility;
	            }
	        }
	        return null;
	    }

	    private double findPrice(List<AssetPrice> prices, String assetId) {
	        for (AssetPrice price : prices) {
	            if (price.getAssetId().equals(assetId)) {
	                return price.getPrice();
	            }
	        }
	        return 0;
	    }
}