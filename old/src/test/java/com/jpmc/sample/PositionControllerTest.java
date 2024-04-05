package com.jpmc.sample;
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

import com.jpmc.sample.controller.PositionController;
import com.jpmc.sample.dto.Account;
import com.jpmc.sample.dto.Position;
import com.jpmc.sample.service.PositionService;


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
        // Arrange
        List<String> accountIds = Arrays.asList("E1");
        List<Account> expectedResult = new ArrayList<>();
        Account acc = new Account();
       
        
        acc.setAccountId("E1");
        List<Position> pList= new ArrayList<Position>();
        Position p1= new Position("S1",100);
        Position p2= new Position("S3",100);
        Position p3= new Position("S4",100);
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        acc.setPositions(pList);
        expectedResult.add(acc);
   
        when(positionService.getPositions(accountIds)).thenReturn(expectedResult);
        List<Account> result = positionController.getAccountPositions(accountIds);
        assertEquals(expectedResult, result);
            
    
    
    }



}

	

	

