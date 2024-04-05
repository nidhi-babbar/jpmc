package com.jpmc.interview.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.interview.dao.EligibilityDao;
import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.service.EligibilityService;

@Service
public class EligibilityServiceImpl implements EligibilityService {
	
	 @Autowired
	 private EligibilityDao eligibilityDao;

    @Override
    public List<Eligibility> checkEligibility(List<String> accountIds, List<String> assetIds) {
         
    
    	List<Eligibility> eligibilities=eligibilityDao.getEligibilities();
         List<Eligibility> filteredByAccount = eligibilities.stream()
                 .filter(eligibility -> anyMatch(eligibility.getAccountIds(), accountIds))
                 .collect(Collectors.toList());


         List<Eligibility> filteredByAsset = filteredByAccount.stream()
                 .filter(eligibility -> anyMatch(eligibility.getAssetIds(), assetIds))
                 .collect(Collectors.toList());

         return filteredByAsset;
	
    }
    
    private boolean anyMatch(List<String> items, List<String> set) {
        for (String item : items) {
            if (set.contains(item)) {
                return true;
            }
        }
        return false;
    }
    
}