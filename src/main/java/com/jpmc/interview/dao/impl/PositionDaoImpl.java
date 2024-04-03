package com.jpmc.interview.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmc.interview.dao.PositionDao;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.Position;

@Repository
public class PositionDaoImpl implements PositionDao{

    @Override
    public List<Account> getPositions(List<String> accountIds) {
        List<Account> accounts = new ArrayList<>();
        List<Position> positions1 = new ArrayList<>();
        positions1.add(new Position("S1", 100));
        positions1.add(new Position("S3", 100));
        positions1.add(new Position("S4", 100));
        accounts.add(new Account("E1", positions1));
        
        List<Position> positions2 = new ArrayList<>();
        positions2.add(new Position("S2", 900));
        positions2.add(new Position("S3", 10));
        positions2.add(new Position("S4", 30));
        accounts.add(new Account("E2", positions2));
        
        List<Account> result = new ArrayList<>();
        for (String accountId : accountIds) {
            for (Account account : accounts) {
                if (account.getAccountId().equals(accountId)) {
                    result.add(account);
                    break;
                }
            }
        }
        return result;
    }
}