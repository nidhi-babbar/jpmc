package com.jpmc.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.interview.dao.PositionDao;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
	
	 @Autowired
	 private PositionDao positionDao;

    @Override
    public List<Account> getPositionsByAccountIds(List<String> accountIds) {
        
        return positionDao.getPositionsByAccountIds(accountIds);
    }
}