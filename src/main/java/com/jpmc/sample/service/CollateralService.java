package com.jpmc.sample.service;

import java.util.List;

import com.jpmc.sample.dto.AccountCollateral;

public interface CollateralService {
    List<AccountCollateral> calculateCollateralValue(List<String> accountIds);
}