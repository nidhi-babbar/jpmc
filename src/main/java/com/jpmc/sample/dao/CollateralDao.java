package com.jpmc.sample.dao;

import com.jpmc.sample.dto.AccountCollateral;

public interface CollateralDao {
	AccountCollateral calculateCollateralValue(String accountId,Double collateralValue);
}