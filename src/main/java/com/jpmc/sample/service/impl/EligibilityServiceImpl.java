package com.jpmc.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.sample.dao.EligibilityDao;
import com.jpmc.sample.dto.Eligibility;
import com.jpmc.sample.service.EligibilityService;

@Service
public class EligibilityServiceImpl implements EligibilityService {
	
	 @Autowired
	 private EligibilityDao eligibilityDao;

    @Override
    public List<Eligibility> checkEligibility(List<String> accountIds, List<String> assetIds) {
        return eligibilityDao.checkEligibility(accountIds, assetIds);
    }
    
    
}