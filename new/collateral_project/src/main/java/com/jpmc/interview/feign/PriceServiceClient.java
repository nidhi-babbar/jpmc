package com.jpmc.interview.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpmc.interview.model.AssetPrice;





@FeignClient(name = "price-service",url = "http://localhost:8081")
public interface PriceServiceClient {

    @GetMapping("/api/prices")
    List<AssetPrice> getPrices(@RequestBody List<String> assetIds);
}