package com.jpmc.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.sample.dto.Account;
import com.jpmc.sample.service.PositionService;

@RestController
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/positions")
    public List<Account> getAccountPositions(@RequestBody List<String> accountIds) {
        return positionService.getPositions(accountIds);
    }
}