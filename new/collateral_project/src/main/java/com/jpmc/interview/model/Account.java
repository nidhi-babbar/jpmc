package com.jpmc.interview.model;

import java.util.List;

public class Account {
	private String accountId;
    private List<Position> positions;
    
    public Account() {
    	
    }

    public Account(String accountId, List<Position> positions) {
        this.accountId = accountId;
        this.positions = positions;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
