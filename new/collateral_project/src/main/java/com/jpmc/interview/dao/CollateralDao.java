package com.jpmc.interview.dao;

import com.jpmc.interview.model.AccountCollateral;

public interface CollateralDao {
	AccountCollateral calculateCollateralValue(String accountId,Double collateralValue);
}