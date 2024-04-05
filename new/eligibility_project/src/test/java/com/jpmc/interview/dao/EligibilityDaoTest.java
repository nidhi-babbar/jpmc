package com.jpmc.interview.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
	       

	        List<Eligibility> result = eligibilityDao.getEligibilities();

	        List<Eligibility> eligibilityList= new ArrayList<Eligibility>();
	        Eligibility expectedEligibility = new Eligibility();
	        expectedEligibility.setEligible(true);
	        expectedEligibility.setAssetIds(Arrays.asList("S1", "S3", "S4"));
	        expectedEligibility.setAccountIds(Arrays.asList("E1"));
	        expectedEligibility.setDiscount(0.9);
	        eligibilityList.add(expectedEligibility);
	        Eligibility expectedEligibility1 = new Eligibility();
	        expectedEligibility1.setEligible(false);
	        expectedEligibility1.setAssetIds(Arrays.asList("S2", "S5"));
	        expectedEligibility1.setAccountIds(Arrays.asList("E1","E2"));
	        eligibilityList.add(expectedEligibility1);
	        
	 
	        assertEquals(eligibilityList.size(), result.size());
	    }



}

	

	

