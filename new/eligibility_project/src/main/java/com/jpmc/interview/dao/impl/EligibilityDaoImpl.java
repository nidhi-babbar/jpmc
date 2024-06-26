package com.jpmc.interview.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmc.interview.dao.EligibilityDao;
import com.jpmc.interview.model.Eligibility;

@Repository
public class EligibilityDaoImpl implements EligibilityDao {

    @Override
    public List<Eligibility> getEligibilities() {
        
        List<Eligibility> eligibilities = new ArrayList<>();
        
        Eligibility eligibility1 = new Eligibility();
        eligibility1.setEligible(true);
        eligibility1.setAssetIds(Arrays.asList("S1", "S2", "S3"));
        eligibility1.setAccountIds(Arrays.asList("E1"));
        eligibility1.setDiscount(0.9);
        eligibilities.add(eligibility1);
        
        Eligibility eligibility2 = new Eligibility();
        eligibility2.setEligible(false);
        eligibility2.setAssetIds(Arrays.asList("S4", "S5"));
        eligibility2.setAccountIds(Arrays.asList("E1",  "E2"));
        eligibilities.add(eligibility2);
        return eligibilities;
       
    }
    
   
}