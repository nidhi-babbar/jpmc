package com.jpmc.interview.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.EligibilityRequest;
import com.jpmc.interview.service.EligibilityService;

@RestController
public class EligibilityController {
	
	private static final Logger logger = LoggerFactory.getLogger(EligibilityController.class);

    @Autowired
    private EligibilityService eligibilityService;

    @PostMapping("/eligibility")
    public List<Eligibility> checkEligibility(@RequestBody EligibilityRequest request) {
    	logger.info("In eligibility Method");
        return eligibilityService.checkEligibility(request.getAccountIds(), request.getAssetIds());
    }
}