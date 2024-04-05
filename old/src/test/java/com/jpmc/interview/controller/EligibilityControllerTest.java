package com.jpmc.interview.controller;
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

import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.EligibilityRequest;
import com.jpmc.interview.service.EligibilityService;


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
    public void testCheckEligibility() {
    	
    	
        	
    	EligibilityRequest eligibilityRequest= new EligibilityRequest();
    	List<String> assetIds = Arrays.asList("S1","S2","S3","S4");
        List<String> accountIds = Arrays.asList("E1");
        eligibilityRequest.setAccountIds(accountIds);
        eligibilityRequest.setAssetIds(assetIds);
        
        
        List<Eligibility> expectedResult = prepareExpectedResult(eligibilityRequest);
     
   
        when(eligibilityService.checkEligibility(eligibilityRequest.getAccountIds(),eligibilityRequest.getAssetIds())).thenReturn(expectedResult);
             
        List<Eligibility> result = eligibilityController.checkEligibility(eligibilityRequest);
        assertEquals(expectedResult, result);
            
    
    
    }

    private List<Eligibility> prepareExpectedResult(EligibilityRequest eligibilityRequest) {
        List<Eligibility> expectedResult = new ArrayList<>();
        Eligibility eligibility = new Eligibility();
        eligibility.setDiscount(0.9);
        eligibility.setEligible(true);
        eligibility.setAccountIds(eligibilityRequest.getAccountIds());
        eligibility.setAssetIds(Arrays.asList("S1", "S2", "S3"));
        expectedResult.add(eligibility);
        return expectedResult;
    }
    
    


}

	

	

