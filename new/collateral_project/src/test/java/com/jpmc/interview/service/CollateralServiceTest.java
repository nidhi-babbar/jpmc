package com.jpmc.interview.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpmc.interview.dao.CollateralDao;
import com.jpmc.interview.exception.BadRequestException;
import com.jpmc.interview.feign.EligibilityServiceClient;
import com.jpmc.interview.feign.PositionServiceClient;
import com.jpmc.interview.feign.PriceServiceClient;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.AccountCollateral;
import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.Position;
import com.jpmc.interview.service.impl.CollateralServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CollateralServiceTest {

    @Mock
    private PositionServiceClient positionServiceClient;

    @Mock
    private EligibilityServiceClient eligibilityServiceClient;

    @Mock
    private PriceServiceClient priceServiceClient;

    @Mock
    private CollateralDao collateralDao;

    @InjectMocks
    private CollateralServiceImpl collateralService;

 

   

    @Test
    public void testCalculateCollateralValue() {
         String accountId = "E1";
		List<String> accountIds = Arrays.asList(accountId);
		Double collateralValue = 5481.0;
		List<String> assetList = Arrays.asList("S3", "S4", "S1");
		List<AssetPrice> expectedPrices = prepareExpectedPrices();
		List<Account> expectedPosition = prepareExpectedPositions(accountId);
		List<Eligibility> expectedEligibility = prepareExpectedEligibility(accountIds);

		when(collateralDao.calculateCollateralValue(accountId, collateralValue))
				.thenReturn(new AccountCollateral(accountId, collateralValue));
		
		when(positionServiceClient.getPositions(accountIds)).thenReturn(expectedPosition);
		when(eligibilityServiceClient.checkEligibility(any())).thenReturn(expectedEligibility);
		when(priceServiceClient.getPrices(assetList)).thenReturn(prepareExpectedPrices());
		List<AccountCollateral> result = collateralService.calculateCollateralValue(accountIds);

		List<AccountCollateral> expectedCollaterals = prepareExpectedCollaterals(accountId, collateralValue);
		assertEquals(expectedCollaterals.get(0).getCollateralValue(), result.get(0).getCollateralValue());

             
       
    }
    
    private List<AccountCollateral> prepareExpectedCollaterals(String accountId, Double collateralValue) {
		List<AccountCollateral> expectedCollaterals = new ArrayList<>();
		AccountCollateral acc = new AccountCollateral();
		acc.setAccountId(accountId);
		acc.setCollateralValue(new BigDecimal(collateralValue));
		expectedCollaterals.add(acc);
		return expectedCollaterals;
	}





private List<AssetPrice> prepareExpectedPrices() {
		List<AssetPrice> expectedPrices = new ArrayList<>();
		
		expectedPrices.add(new AssetPrice("S3", 10.4));
		expectedPrices.add(new AssetPrice("S4", 15.5));
		expectedPrices.add(new AssetPrice("S1", 50.5));
		return expectedPrices;
	}

	private List<Account> prepareExpectedPositions(String accountId) {
		List<Account> expectedPosition = new ArrayList<>();
		Account account = new Account();
		account.setAccountId(accountId);
		List<Position> pList = new ArrayList<Position>();
		pList.add(new Position("S3", 100));
		pList.add(new Position("S4", 100));
		pList.add(new Position("S1", 100));
		account.setPositions(pList);
		expectedPosition.add(account);
		return expectedPosition;
	}

	private List<Eligibility> prepareExpectedEligibility(List<String> accountIds) {
		List<Eligibility> expectedEligibility = new ArrayList<>();
		Eligibility eligibility = new Eligibility();
		eligibility.setDiscount(0.9);
		eligibility.setEligible(true);
		List<String> assetIdList = Arrays.asList("S1", "S2", "S3");
		
		eligibility.setAccountIds(accountIds);
		eligibility.setAssetIds(assetIdList);
		expectedEligibility.add(eligibility);
		return expectedEligibility;
	}
}
