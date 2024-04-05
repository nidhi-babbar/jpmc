package com.jpmc.interview.dao;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.jpmc.interview.dao.impl.PositionDaoImpl;
import com.jpmc.interview.model.Account;
import com.jpmc.interview.model.Position;


public class PositionDaoTest {
	
	    @InjectMocks
	    private PositionDaoImpl positionDao;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGetPositions() {
	        List<String> accountIds = Arrays.asList("E1", "E2");
	        List<Account> expectedAccounts = Arrays.asList(
	            new Account("E1", Arrays.asList(
	                new Position("S1", 100),
	                new Position("S3", 100),
	                new Position("S4", 100)
	            )),
	            new Account("E2", Arrays.asList(
	                new Position("S2", 900),
	                new Position("S3", 10),
	                new Position("S4", 30)
	            ))
	        );

	        List<Account> actualAccounts = positionDao.getPositionsByAccountIds(accountIds);
	        assertEquals(expectedAccounts.size(), actualAccounts.size());
	    }
	}





	

	

