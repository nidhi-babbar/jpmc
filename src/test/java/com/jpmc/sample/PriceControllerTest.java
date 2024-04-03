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

import com.jpmc.sample.controller.PriceController;
import com.jpmc.sample.dto.Account;
import com.jpmc.sample.dto.AssetPrice;
import com.jpmc.sample.dto.Position;
import com.jpmc.sample.service.PriceService;


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
        List<String> assetIds = Arrays.asList("S1","S2","S3","S4");
        List<AssetPrice> expectedResult = new ArrayList<>();
        AssetPrice assetPrice1 = new AssetPrice("S1",50.5);
        AssetPrice assetPrice2 = new AssetPrice("S2",20.2);
        AssetPrice assetPrice3 = new AssetPrice("S3",10.4);
        AssetPrice assetPrice4 = new AssetPrice("S4",15.5);
        expectedResult.add(assetPrice1);
        expectedResult.add(assetPrice2);
        expectedResult.add(assetPrice3);
        expectedResult.add(assetPrice4);
   
        when(priceService.getPrices(assetIds)).thenReturn(expectedResult);
        
        
        List<AssetPrice> result = priceController.getAssetPrices(assetIds);
        assertEquals(expectedResult, result);
            
    
    
    }



}

	

	

