package com.jpmc.sample;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jpmc.sample.controller.CollateralController;
import com.jpmc.sample.dto.AccountCollateral;
import com.jpmc.sample.service.CollateralService;


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
        // Arrange
        List<String> accountIds = Arrays.asList("E1");
        List<AccountCollateral> expectedCollaterals = new ArrayList<>();
        AccountCollateral acc = new AccountCollateral();
        
        acc.setAccountId("E1");
        acc.setCollateralValue(new BigDecimal(6876));
        expectedCollaterals.add(acc);
   
        when(collateralService.calculateCollateralValue(accountIds)).thenReturn(expectedCollaterals);

      
        List<AccountCollateral> result = collateralController.calculateCollateralValue(accountIds);
        assertEquals(expectedCollaterals, result);
            
    
    
    }



}

	

	

