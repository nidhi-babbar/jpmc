package com.jpmc.interview.dao.impl;

import org.springframework.stereotype.Repository;

import com.jpmc.interview.dao.CollateralDao;
import com.jpmc.interview.model.AccountCollateral;

@Repository
public class CollateralDaoImpl implements CollateralDao {


	    @Override
	    public AccountCollateral calculateCollateralValue(String accountId,Double collateralValue) {
        
			
	        return new AccountCollateral(accountId, collateralValue);
	    }

	   
}