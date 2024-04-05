package com.jpmc.interview.service;
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

import com.jpmc.interview.dao.PositionDao;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.Position;
import com.jpmc.interview.service.impl.PositionServiceImpl;


public class PositionServiceTest {
	
	@Mock
    private PositionDao positionDao;

    @InjectMocks
    private PositionServiceImpl positionService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testGetPositions() {
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
   
        when(positionDao.getPositions(accountIds)).thenReturn(expectedResult);
        List<Account> result = positionService.getPositions(accountIds);
        assertEquals(expectedResult, result);
            
    
    
    }



}

	

	

