package com.jpmc.sample;
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

import com.jpmc.sample.controller.EligibilityController;
import com.jpmc.sample.dto.Account;
import com.jpmc.sample.dto.AssetPrice;
import com.jpmc.sample.dto.Eligibility;
import com.jpmc.sample.dto.EligibilityRequest;
import com.jpmc.sample.service.EligibilityService;


public class EligibilityControllerTest {
	
	@Mock
    private EligibilityService eligibilityService;

    @InjectMocks
    private EligibilityController eligibilityController;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testPriceValues() {
    	
    	
        	
    	EligibilityRequest eligibilityRequest= new EligibilityRequest();
    	List<String> assetIds = Arrays.asList("S1","S2","S3","S4");
        List<String> accountIds = Arrays.asList("E1");
        eligibilityRequest.setAccountIds(accountIds);
        eligibilityRequest.setAssetIds(assetIds);
        
        
        List<Eligibility> expectedResult = new ArrayList<Eligibility>();
        
        Eligibility eligibility= new Eligibility();
        eligibility.setDiscount(0.9);
        eligibility.setEligible(true);
        List<String> assetIdList = Arrays.asList("S1","S2","S3");
        List<String> accountIdList = Arrays.asList("E1");
        eligibility.setAccountIds(accountIdList);
        eligibility.setAssetIds(assetIdList);
        
        
        expectedResult.add(eligibility);
     
   
        when(eligibilityService.checkEligibility(eligibilityRequest.getAccountIds(),eligibilityRequest.getAssetIds())).thenReturn(expectedResult);
             
        List<Eligibility> result = eligibilityController.checkEligibility(eligibilityRequest);
        assertEquals(expectedResult, result);
            
    
    
    }



}

	

	

