package com.jpmc.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.sample.dto.AccountCollateral;
import com.jpmc.sample.exception.BadRequestException;
import com.jpmc.sample.service.CollateralService;

@RestController
public class CollateralController {

    @Autowired
    private CollateralService collateralService;

    @PostMapping("/collateral")
    public List<AccountCollateral> calculateCollateralValue(@RequestBody List<String> accountIds) {
    	
    	  if(accountIds ==null || accountIds.size()==0) {
	    	   throw new BadRequestException("Account id is empty ");
	       }
	    	

        return collateralService.calculateCollateralValue(accountIds);
    }
}