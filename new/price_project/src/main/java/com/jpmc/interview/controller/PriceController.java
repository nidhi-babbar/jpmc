package  com.jpmc.interview.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.interview.model.AssetPrice;
import com.jpmc.interview.service.PriceService;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/api/prices")
    public List<AssetPrice> getPricesByAssetIds(@RequestBody List<String> assetIds) {
        return priceService.getPricesByAssetIds(assetIds);
    }
}
