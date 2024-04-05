package com.jpmc.interview.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpmc.interview.model.Eligibility;
import com.jpmc.interview.model.EligibilityRequest;

@FeignClient(name = "eligibility-service", url = "http://localhost:8083")
public interface EligibilityServiceClient {

    @GetMapping("/api/eligibility")
    List<Eligibility> checkEligibility(@RequestBody EligibilityRequest request);
}