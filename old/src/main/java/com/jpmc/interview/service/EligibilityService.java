package com.jpmc.interview.service;

import java.util.List;

import com.jpmc.interview.model.Eligibility;

public interface EligibilityService {
    List<Eligibility> checkEligibility(List<String> accountIds, List<String> assetIds);
}