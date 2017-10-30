package com.bluexiii.zen.service;

import com.bluexiii.zen.client.StaticInfoClient;
import com.bluexiii.zen.domain.TdBProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

/**
 * Created by bluexiii on 17/08/2017.
 */
@RunWith(SpringRunner.class)
public class FeignSampleServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(FeignSampleServiceTest.class);
    @InjectMocks
    private FeignSampleService feignSampleService;

    @MockBean
    private StaticInfoClient staticInfoClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        given(this.staticInfoClient.getProductInfo(99999830L)).willReturn(buildProduct(99999830L, "产品名称"));
    }


    private TdBProduct buildProduct(Long id, String name) {
        TdBProduct tdBProduct = new TdBProduct();
        tdBProduct.setProductId(id);
        tdBProduct.setProductName(name);
        return tdBProduct;
    }

    @Test
    public void getProductInfo() throws Exception {
        TdBProduct productInfo = feignSampleService.getProductInfo(99999830L);
        logger.info(productInfo.toString());

    }

    public static void main(String[] args) {
        String[] a = null;


    }
}