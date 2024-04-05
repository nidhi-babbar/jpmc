package com.jpmc.interview.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jpmc.interview.exception.BadRequestException;
import com.jpmc.interview.model.AccountCollateral;
import com.jpmc.interview.service.CollateralService;


public class CollateralControllerTest {
	
	@Mock
    private CollateralService collateralService;

    @InjectMocks
    private CollateralController collateralController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateCollateralValue() {
     
    	  List<String> accountIds = Arrays.asList("E1");
    	 List<AccountCollateral> expectedCollaterals = prepareExpectedCollaterals();
        when(collateralService.calculateCollateralValue(accountIds)).thenReturn(expectedCollaterals);
        List<AccountCollateral> result = collateralController.calculateCollateralValue(accountIds);
        assertEquals(expectedCollaterals, result);
            
    
    
    }
    
    private List<AccountCollateral> prepareExpectedCollaterals() {
        List<AccountCollateral> expectedCollaterals = new ArrayList<>();
        AccountCollateral acc = new AccountCollateral();
        acc.setAccountId("E1");
        acc.setCollateralValue(new BigDecimal(6876));
        expectedCollaterals.add(acc);
        return expectedCollaterals;
    }





}

	

	

