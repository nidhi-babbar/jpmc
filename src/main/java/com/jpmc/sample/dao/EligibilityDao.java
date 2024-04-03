package com.jpmc.sample.dao;

import java.util.List;

import com.jpmc.sample.dto.Eligibility;

public interface EligibilityDao {
    List<Eligibility> checkEligibility(List<String> accountIds, List<String> assetIds);
}