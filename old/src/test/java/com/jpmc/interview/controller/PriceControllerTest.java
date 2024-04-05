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

import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.service.PriceService;


public class PriceControllerTest {
	
	@Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testPriceValues() {
     List<String> assetIds = Arrays.asList("S1", "S2", "S3", "S4");
      List<AssetPrice> expectedResult = prepareExpectedResult();
   
        when(priceService.getPrices(assetIds)).thenReturn(expectedResult);
        
        
        List<AssetPrice> result = priceController.getAssetPrices(assetIds);
        assertEquals(expectedResult, result);
            
    
    
    }
    
    private List<AssetPrice> prepareExpectedResult() {
        List<AssetPrice> expectedResult = new ArrayList<>();
        expectedResult.add(new AssetPrice("S1", 50.5));
        expectedResult.add(new AssetPrice("S2", 20.2));
        expectedResult.add(new AssetPrice("S3", 10.4));
        expectedResult.add(new AssetPrice("S4", 15.5));
        return expectedResult;
    }



}

	

	

