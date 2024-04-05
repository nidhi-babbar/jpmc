package com.jpmc.interview.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpmc.interview.model.Account;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "position-service", url = "http://localhost:8082")
public interface PositionServiceClient {

    @GetMapping("/api/positions")
    List<Account> getPositions(@RequestBody List<String> accountIds);
}