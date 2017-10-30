package com.bluexiii.zen.web;

import com.bluexiii.zen.domain.TdBProduct;
import com.bluexiii.zen.service.FeignSampleService;
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
@Api(value = "Feign示例", description = "Feign示例")
@RequestMapping("${custom.baseurl}")
public class FeignSampleController {
    @Autowired
    private FeignSampleService feignSampleService;

    @ApiOperation(value = "Feign查询产品配置")
    @RequestMapping(value = "/feignsample/{productId}", method = RequestMethod.GET)
    public TdBProduct getProductInfo(@ApiParam(value = "产品编码", required = true) @PathVariable Long productId) {
        return feignSampleService.getProductInfo(productId);
    }
}
