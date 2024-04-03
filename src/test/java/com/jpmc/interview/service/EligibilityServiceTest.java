package com.jpmc.interview.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jpmc.interview.dao.EligibilityDao;
import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.service.impl.EligibilityServiceImpl;


public class EligibilityServiceTest {
	
	@Mock
    private EligibilityDao eligibilityDao;

    @InjectMocks
    private EligibilityServiceImpl eligibilityService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testPriceValues() {
    	
    	
        	
    
    	List<String> assetIds = Arrays.asList("S1","S2","S3","S4");
        List<String> accountIds = Arrays.asList("E1");
       
        
        List<Eligibility> expectedResult = new ArrayList<Eligibility>();
        Eligibility eligibility= new Eligibility();
        eligibility.setDiscount(0.9);
        eligibility.setEligible(true);
        List<String> assetIdList = Arrays.asList("S1","S2","S3");
        List<String> accountIdList = Arrays.asList("E1");
        eligibility.setAccountIds(accountIdList);
        eligibility.setAssetIds(assetIdList);
        expectedResult.add(eligibility);
        when(eligibilityDao.checkEligibility(accountIds,assetIds)).thenReturn(expectedResult);
             
        List<Eligibility> result = eligibilityService.checkEligibility(accountIds,assetIds);
        assertEquals(expectedResult, result);
            
    
    
    }



}

	

	

