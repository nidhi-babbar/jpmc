package com.jpmc.sample.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmc.sample.dao.EligibilityDao;
import com.jpmc.sample.dto.Eligibility;

@Repository
public class EligibilityDaoImpl implements EligibilityDao {

    @Override
    public List<Eligibility> checkEligibility(List<String> accountIds, List<String> assetIds) {
        
        List<Eligibility> eligibilities = new ArrayList<>();
        
        Eligibility eligibility1 = new Eligibility();
        eligibility1.setEligible(true);
        eligibility1.setAssetIds(Arrays.asList("S1", "S3", "S4"));
        eligibility1.setAccountIds(Arrays.asList("E1"));
        eligibility1.setDiscount(0.9);
        eligibilities.add(eligibility1);
        
        Eligibility eligibility2 = new Eligibility();
        eligibility2.setEligible(false);
        eligibility2.setAssetIds(Arrays.asList("S2", "S5"));
        eligibility2.setAccountIds(Arrays.asList("E1",  "E2"));
        eligibilities.add(eligibility2);
        
        List<Eligibility> finalEligibilities = new ArrayList<>();
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