package com.jpmc.interview.dao;

import java.util.List;

import com.jpmc.interview.model.Account;

public interface PositionDao {
    List<Account> getPositionsByAccountIds(List<String> accountIds);
}
