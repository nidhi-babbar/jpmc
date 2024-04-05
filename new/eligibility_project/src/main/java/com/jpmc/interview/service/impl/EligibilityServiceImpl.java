package com.jpmc.interview.service.impl;

import java.util.ArrayList;
import java.util.List;

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
         
    	List<Eligibility> finalEligibilities = new ArrayList<>();
    	List<Eligibility> eligibilities=eligibilityDao.getEligibilities();
         
         for (Eligibility eligibility : eligibilities) {
             if (containsAll(eligibility.getAccountIds(), accountIds) &&
                 containsAll(eligibility.getAssetIds(), assetIds)) {
             	finalEligibilities.add(eligibility);
             }
         }
         
         return finalEligibilities;
    }
    
    private boolean containsAll(List<String> listToCheck, List<String> values) {
        return listToCheck.containsAll(values);
    }
    
}