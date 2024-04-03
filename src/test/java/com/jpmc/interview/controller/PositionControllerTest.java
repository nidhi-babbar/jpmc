package com.jpmc.interview.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.Position;
import com.jpmc.interview.service.PositionService;


public class PositionControllerTest {
	
	@Mock
    private PositionService positionService;

    @InjectMocks
    private PositionController positionController;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testPositionValue() {
        List<String> accountIds = Arrays.asList("E1");
        List<Account> expectedResult = prepareExpectedResult(accountIds);
        when(positionService.getPositions(accountIds)).thenReturn(expectedResult);
        List<Account> result = positionController.getAccountPositions(accountIds);
        assertEquals(expectedResult, result);
    }

    private List<Account> prepareExpectedResult(List<String> accountIds) {
        List<Account> expectedResult = new ArrayList<>();
        Account acc = new Account();
        acc.setAccountId("E1");
        List<Position> pList = new ArrayList<Position>();
        pList.add(new Position("S1", 100));
        pList.add(new Position("S3", 100));
        pList.add(new Position("S4", 100));
        acc.setPositions(pList);
        expectedResult.add(acc);
        return expectedResult;
    }


}

	

	

