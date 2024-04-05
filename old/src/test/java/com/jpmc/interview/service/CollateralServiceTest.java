package com.jpmc.interview.service;
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

import com.jpmc.interview.dao.CollateralDao;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.AccountCollateral;
import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.Position;
import com.jpmc.interview.service.impl.CollateralServiceImpl;


public class CollateralServiceTest {
	
	@Mock
    private CollateralDao collateralDao;
	
	@Mock
    private EligibilityService eligibilityService;
	
	@Mock
    private PositionService positionService;
	
	@Mock
    private PriceService priceService;

    @InjectMocks
    private CollateralServiceImpl collateralService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    

    @Test
    public void testCalculateCollateralValue() {
    
        String accountId = "E1";
        List<String> accountIds = Arrays.asList(accountId);
        Double collateralValue = 6876.0;
        List<String> assetIds = Arrays.asList("S1", "S3", "S4");
        List<AssetPrice> expectedPrices = prepareExpectedPrices();
        List<Account> expectedPosition = prepareExpectedPositions(accountId);
        List<Eligibility> expectedEligibility = prepareExpectedEligibility(accountIds, assetIds);

    
        when(collateralDao.calculateCollateralValue(accountId, collateralValue))
                .thenReturn(new AccountCollateral(accountId, collateralValue));
        when(priceService.getPrices(assetIds)).thenReturn(expectedPrices);
        when(positionService.getPositions(accountIds)).thenReturn(expectedPosition);
        when(eligibilityService.checkEligibility(accountIds, assetIds)).thenReturn(expectedEligibility);


        List<AccountCollateral> result = collateralService.calculateCollateralValue(accountIds);

  
        List<AccountCollateral> expectedCollaterals = prepareExpectedCollaterals(accountId, collateralValue);
        assertEquals(expectedCollaterals.get(0).getCollateralValue(), result.get(0).getCollateralValue());
    }

    private List<AssetPrice> prepareExpectedPrices() {
        List<AssetPrice> expectedPrices = new ArrayList<>();
        expectedPrices.add(new AssetPrice("S1", 50.5));
        expectedPrices.add(new AssetPrice("S3", 10.4));
        expectedPrices.add(new AssetPrice("S4", 15.5));
        return expectedPrices;
    }

    private List<Account> prepareExpectedPositions(String accountId) {
        List<Account> expectedPosition = new ArrayList<>();
        Account account = new Account();
        account.setAccountId(accountId);
        List<Position> pList = new ArrayList<Position>();
        pList.add(new Position("S1", 100));
        pList.add(new Position("S3", 100));
        pList.add(new Position("S4", 100));
        account.setPositions(pList);
        expectedPosition.add(account);
        return expectedPosition;
    }

    private List<Eligibility> prepareExpectedEligibility(List<String> accountIds, List<String> assetIds) {
        List<Eligibility> expectedEligibility = new ArrayList<>();
        Eligibility eligibility = new Eligibility();
        eligibility.setDiscount(0.9);
        eligibility.setEligible(true);
        eligibility.setAccountIds(accountIds);
        eligibility.setAssetIds(assetIds);
        expectedEligibility.add(eligibility);
        return expectedEligibility;
    }

    private List<AccountCollateral> prepareExpectedCollaterals(String accountId, Double collateralValue) {
        List<AccountCollateral> expectedCollaterals = new ArrayList<>();
        AccountCollateral acc = new AccountCollateral();
        acc.setAccountId(accountId);
        acc.setCollateralValue(new BigDecimal(collateralValue));
        expectedCollaterals.add(acc);
        return expectedCollaterals;
    }


}

	

	

