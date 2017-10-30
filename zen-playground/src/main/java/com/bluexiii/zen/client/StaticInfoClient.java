package com.bluexiii.zen.client;

import com.bluexiii.zen.domain.TdBProduct;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bluexiii on 17/08/2017.
 */
//@FeignClient(name = "marathon-lb-internal", fallback = StaticInfoClientMyFallback.class)
@FeignClient(name = "zen-playground", fallback = StaticInfoClientMyFallback.class)
public interface StaticInfoClient {
    /**
     * 产品定询查询客户端
     *
     * @param productId 99999830
     * @return
     */
    @RequestMapping(value = "/demo/productdefs/{productId}", method = RequestMethod.GET)
    public TdBProduct getProductInfo(@PathVariable("productId") Long productId);

}

@Component
class StaticInfoClientMyFallback implements StaticInfoClient {
    @Override
    public TdBProduct getProductInfo(Long productId) {
        TdBProduct tdBProduct = new TdBProduct();
        tdBProduct.setProductId(productId);
        tdBProduct.setProductName("暂时无法查询");
        return tdBProduct;
    }
}