package com.jpmc.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.sample.dao.PositionDao;
import com.jpmc.sample.dto.Account;
import com.jpmc.sample.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
	
	 @Autowired
	 private PositionDao positionDao;

    @Override
    public List<Account> getPositions(List<String> accountIds) {
        
        return positionDao.getPositions(accountIds);
    }
}