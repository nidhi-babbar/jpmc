package com.jpmc.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.interview.model.Account;
import com.jpmc.interview.service.PositionService;

@RestController
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/api/positions")
    public List<Account> getPositionsByAccountIds(@RequestBody List<String> accountIds) {
        return positionService.getPositionsByAccountIds(accountIds);
    }
}