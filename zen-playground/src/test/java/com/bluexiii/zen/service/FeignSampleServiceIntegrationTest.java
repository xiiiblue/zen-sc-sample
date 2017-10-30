package com.bluexiii.zen.service;

import com.bluexiii.zen.domain.TdBProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bluexiii on 17/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignSampleServiceIntegrationTest {
    private static final Logger logger = LoggerFactory.getLogger(FeignSampleServiceIntegrationTest.class);
    @Autowired
    private FeignSampleService feignSampleService;

    @Test
    public void getProductInfo() throws Exception {
        TdBProduct productInfo = feignSampleService.getProductInfo(99999830L);
        logger.info(productInfo.toString());
    }
}