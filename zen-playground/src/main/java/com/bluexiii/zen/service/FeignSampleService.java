package com.bluexiii.zen.service;

import com.bluexiii.zen.client.StaticInfoClient;
import com.bluexiii.zen.domain.TdBProduct;
import com.bluexiii.zen.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bluexiii on 11/08/2017.
 */
@Service
public class FeignSampleService {
    @Autowired
    private StaticInfoClient staticInfoClient;

    /**
     * 查询产品定义
     *
     * @param productId
     * @return
     */
    public TdBProduct getProductInfo(Long productId) {
        TdBProduct tdBProduct = staticInfoClient.getProductInfo(productId);
        if (tdBProduct == null) {
            throw new ResourceNotFoundException(String.format("不存在 productId=%s", productId));
        }
        return tdBProduct;
    }
}
