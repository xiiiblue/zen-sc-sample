package com.bluexiii.zen.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bluexiii on 11/08/2017.
 */
@RefreshScope
@RestController
@Api(value = "配置中心示例", description = "配置中心示例")
@RequestMapping("${custom.baseurl}")
public class ConfigClientController {
    @Value("${message:Hello default}")
    private String message;

    @HystrixCommand(
            fallbackMethod = "",  // Use Exception Handler
            ignoreExceptions = {Exception.class}
    )
    @ApiOperation(value = "配置中心示例")
    @RequestMapping(value = "/configclient", method = RequestMethod.GET)
    public String getConfigMessage() {
        return message;
    }
}
