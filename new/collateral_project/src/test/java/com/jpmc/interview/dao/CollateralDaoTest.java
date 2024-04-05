package com.jpmc.interview.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.interview.dao.impl.CollateralDaoImpl;
import com.jpmc.interview.model.AccountCollateral;

public class CollateralDaoTest {
	
	  @InjectMocks
	  private CollateralDaoImpl collateralDao;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }
 
	@Test
    public void testCalculateCollateralValue() {
   
        String accountId = "E1";
        Double collateralValue = 6876.00;
        AccountCollateral result = collateralDao.calculateCollateralValue(accountId, collateralValue);
        AccountCollateral expectedCollateral = new AccountCollateral(accountId, collateralValue);
        assertEquals(expectedCollateral.getAccountId(), result.getAccountId());
    }


}

	

	

