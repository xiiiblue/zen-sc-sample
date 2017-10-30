package com.bluexiii.zen.web;

import com.bluexiii.zen.domain.TdBProduct;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.bluexiii.zen.service.ProductDefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bluexiii on 11/08/2017.
 */
@RestController
@Api(value = "静态配置", description = "静态配置")
@RequestMapping("${custom.baseurl}")
public class ProductDefController {
    @Autowired
    private ProductDefService definitionService;

    @HystrixCommand(
            fallbackMethod = "",  // Use Exception Handler
            ignoreExceptions = {Exception.class}
    )
    @ApiOperation(value = "查询产品配置")
    @RequestMapping(value = "/productdefs/{productId}", method = RequestMethod.GET)
    public TdBProduct getProductInfo(@ApiParam(value = "产品编码", required = true) @PathVariable Long productId) {
        return definitionService.getProductInfo(productId);
    }
}
