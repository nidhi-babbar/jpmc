package com.jpmc.interview.dao;

import java.util.List;

import com.jpmc.interview.model.Eligibility;

public interface EligibilityDao {
    List<Eligibility> getEligibilities();
}