package com.jpmc.sample.dao.impl;

import org.springframework.stereotype.Repository;

import com.jpmc.sample.dao.CollateralDao;
import com.jpmc.sample.dto.AccountCollateral;

@Repository
public class CollateralDaoImpl implements CollateralDao {


	    @Override
	    public AccountCollateral calculateCollateralValue(String accountId,Double collateralValue) {
        
			
	        return new AccountCollateral(accountId, collateralValue);
	    }

	   
}