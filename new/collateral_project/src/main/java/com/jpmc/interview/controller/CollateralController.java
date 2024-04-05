package com.jpmc.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.interview.exception.BadRequestException;
import com.jpmc.interview.model.AccountCollateral;
import com.jpmc.interview.service.CollateralService;

@RestController
public class CollateralController {

    @Autowired
    private CollateralService collateralService;

    @PostMapping("/api/collateral")
    public List<AccountCollateral> calculateCollateralValue(@RequestBody List<String> accountIds) {
    	
    	
	   
        return collateralService.calculateCollateralValue(accountIds);
    }
}