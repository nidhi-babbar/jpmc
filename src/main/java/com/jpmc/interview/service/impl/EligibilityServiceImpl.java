package com.jpmc.interview.service.impl;

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
        return eligibilityDao.checkEligibility(accountIds, assetIds);
    }
    
    
}