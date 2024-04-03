package com.jpmc.sample.service;

import java.util.List;

import com.jpmc.sample.dto.Account;

public interface PositionService {
    List<Account> getPositions(List<String> accountIds);
}
