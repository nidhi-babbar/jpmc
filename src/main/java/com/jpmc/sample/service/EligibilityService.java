package com.jpmc.sample.service;

import java.util.List;

import com.jpmc.sample.dto.Eligibility;

public interface EligibilityService {
    List<Eligibility> checkEligibility(List<String> accountIds, List<String> assetIds);
}