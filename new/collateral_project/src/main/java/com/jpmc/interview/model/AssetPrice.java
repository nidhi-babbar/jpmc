package com.jpmc.interview.model;

public class AssetPrice {
	
    private String assetId;
    private double price;


    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public AssetPrice(String assetId, double price) {
		super();
		this.assetId = assetId;
		this.price = price;
	}
}