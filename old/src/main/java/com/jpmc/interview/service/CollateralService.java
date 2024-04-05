package com.jpmc.interview.service;

import java.util.List;

import com.jpmc.interview.model.AccountCollateral;

public interface CollateralService {
    List<AccountCollateral> calculateCollateralValue(List<String> accountIds);
}