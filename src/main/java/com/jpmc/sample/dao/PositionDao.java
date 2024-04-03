package com.jpmc.sample.dao;

import java.util.List;

import com.jpmc.sample.dto.Account;

public interface PositionDao {
    List<Account> getPositions(List<String> accountIds);
}
