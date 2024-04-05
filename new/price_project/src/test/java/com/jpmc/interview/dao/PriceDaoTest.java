package com.jpmc.interview.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.interview.dao.impl.PriceDaoImpl;
import com.jpmc.interview.model.AssetPrice;

public class PriceDaoTest {
	
	  @InjectMocks
	    private PriceDaoImpl priceDao;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGetPrices() {

	        List<String> assetIds = Arrays.asList("S1", "S2", "S3");
	       
	        
	  
	        List<AssetPrice> result = priceDao.getPricesByAssetIds(assetIds);

	 
	        List<AssetPrice> expected = Arrays.asList(
	            new AssetPrice("S1", 50.5),
	            new AssetPrice("S2", 20.2),
	            new AssetPrice("S3", 10.4)
	        );

	   
	        assertEquals(expected.size(), result.size());
	    }
	


}

	

	

