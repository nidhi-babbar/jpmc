package  com.jpmc.sample.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.sample.dto.AssetPrice;
import com.jpmc.sample.service.PriceService;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/prices")
    public List<AssetPrice> getAssetPrices(@RequestBody List<String> assetIds) {
        return priceService.getPrices(assetIds);
    }
}
