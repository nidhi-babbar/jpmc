package com.jpmc.interview.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jpmc.interview.dao.CollateralDao;
import com.jpmc.interview.exception.BadRequestException;
import com.jpmc.interview.feign.EligibilityServiceClient;
import com.jpmc.interview.feign.PositionServiceClient;
import com.jpmc.interview.feign.PriceServiceClient;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.AccountCollateral;
import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.EligibilityRequest;
import com.jpmc.interview.model.Position;
import com.jpmc.interview.service.CollateralService;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;




@Service

public class CollateralServiceImpl implements CollateralService {
	
	 

	    @Autowired
	    private PositionServiceClient  positionServiceClient;

	    @Autowired
	    private EligibilityServiceClient  eligibilityServiceClient ;

	    @Autowired
	    private PriceServiceClient  priceServiceClient ;
	    
	    @Autowired
		 private CollateralDao collateralDao;
	    
	    List<Account> account=null;
	    Set<String> assetIds= new HashSet();
	 
	    
	 
	    @Override
	    @CircuitBreaker(name = "priceService", fallbackMethod = "fallbackMethod1")
	  	 public List<AccountCollateral> calculateCollateralValue(List<String> accountIds) {
	    	
	    	
	    	
	       if(accountIds ==null || accountIds.size()==0) {
	    	   throw new BadRequestException("Account id is empty");
	       }
	       
	       List<AssetPrice> prices= new ArrayList<AssetPrice>();
	      List<AccountCollateral> accountCollaterals = new ArrayList<>();
	         account = positionServiceClient.getPositions(accountIds);
	    	for(Account acc:account) {
	    		assetIds.addAll(extractAssetIds(acc.getPositions()));
	    	    }
	    	List<String> assetList = new ArrayList<>(assetIds);
	    	
	         prices = priceServiceClient.getPrices(assetList);
	    	
	        EligibilityRequest request= new EligibilityRequest();
	        request.setAccountIds(accountIds);
	        request.setAssetIds(assetList);
	        List<Eligibility> eligibility = eligibilityServiceClient.checkEligibility(request);
			for(Account acc:account) {
	        double collateralValue = calculateAccountCollateral(acc.getAccountId(), acc.getPositions(), eligibility, prices);
            accountCollaterals.add(collateralDao.calculateCollateralValue(acc.getAccountId(),collateralValue));
			}

	   

	        return accountCollaterals;
	    }
	    
	   
		   public List<AccountCollateral> fallbackMethod1(List<String> accountIds,Throwable throwable)  {
	    	List<AccountCollateral> accountCollaterals = new ArrayList<>();
	    	  List<AssetPrice> prices = new ArrayList<>();
	          prices.add(new AssetPrice("S1", 50.5));
	          prices.add(new AssetPrice("S2", 20.2));
	          prices.add(new AssetPrice("S3", 10.4));
	          prices.add(new AssetPrice("S4", 15.5));
	    	    EligibilityRequest request= new EligibilityRequest();
		        request.setAccountIds(accountIds);
		        List<String> assetList = new ArrayList<>(assetIds);
		        request.setAssetIds(assetList);
		        List<Eligibility> eligibility = eligibilityServiceClient.checkEligibility(request);
				for(Account acc:account) {
		        double collateralValue = calculateAccountCollateral(acc.getAccountId(), acc.getPositions(), eligibility, prices);
	            accountCollaterals.add(collateralDao.calculateCollateralValue(acc.getAccountId(),collateralValue));
				}
		        return accountCollaterals;
	       
	    }
	    


	    private Set<String> extractAssetIds(List<Position> positions) {
	        Set<String> assetIds = new HashSet<>();
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