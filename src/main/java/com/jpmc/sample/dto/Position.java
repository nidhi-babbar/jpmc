package com.jpmc.sample.dto;

public class Position {

	 private String assetId;
	 private int quantity;

	 
	 
	public Position(String assetId, int quantity) {
		super();
		this.assetId = assetId;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

}
