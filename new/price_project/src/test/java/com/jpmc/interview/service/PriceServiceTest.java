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

import com.jpmc.interview.dao.PriceDao;
import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.service.impl.PriceServiceImpl;


public class PriceServiceTest {
	
	@Mock
    private PriceDao priceDao;
	

    @InjectMocks
    private PriceServiceImpl priceService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testGetPrices() {
    	List<String> assetIds = Arrays.asList("S1", "S2", "S3", "S4");
        List<AssetPrice> expectedResult = Arrays.asList(
            new AssetPrice("S1", 50.5),
            new AssetPrice("S2", 20.2),
            new AssetPrice("S3", 10.4),
            new AssetPrice("S4", 15.5)
        );
   
        when(priceDao.getPricesByAssetIds(assetIds)).thenReturn(expectedResult);
        
        
        List<AssetPrice> result = priceService.getPricesByAssetIds(assetIds);
        assertEquals(expectedResult, result);
            
    
    
    }



}

	

	

