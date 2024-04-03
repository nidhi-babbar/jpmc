package com.jpmc.interview.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.interview.dao.impl.EligibilityDaoImpl;
import com.jpmc.interview.model.Eligibility;

public class EligibilityDaoTest {
	
	
	    @InjectMocks
	    private EligibilityDaoImpl eligibilityDao;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }
	
	   @Test
	    public void testCheckEligibility() {
	       
	        List<String> accountIds = Arrays.asList("E1");
	        List<String> assetIds = Arrays.asList("S1", "S3");
	        List<Eligibility> result = eligibilityDao.checkEligibility(accountIds, assetIds);

	        
	        Eligibility expectedEligibility = new Eligibility();
	        expectedEligibility.setEligible(true);
	        expectedEligibility.setAssetIds(Arrays.asList("S1", "S3", "S4"));
	        expectedEligibility.setAccountIds(Arrays.asList("E1"));
	        expectedEligibility.setDiscount(0.9);
	        
	 
	        assertEquals(Arrays.asList(expectedEligibility).size(), result.size());
	    }



}

	

	

