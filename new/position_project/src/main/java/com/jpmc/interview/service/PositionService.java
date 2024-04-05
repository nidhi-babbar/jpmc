package com.jpmc.interview.service;

import java.util.List;

import com.jpmc.interview.model.Account;

public interface PositionService {
    List<Account> getPositionsByAccountIds(List<String> accountIds);
}
