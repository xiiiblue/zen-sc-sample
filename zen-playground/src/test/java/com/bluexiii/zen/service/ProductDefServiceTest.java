package com.bluexiii.zen.service;

import com.bluexiii.zen.exception.ResourceNotFoundException;
import com.bluexiii.zen.domain.TdBProduct;
import com.bluexiii.zen.repository.TdBProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Created by bluexiii on 11/08/2017.
 */
@RunWith(SpringRunner.class)
public class ProductDefServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductDefServiceTest.class);

    @MockBean
    private TdBProductRepository tdBProductRepository;

    @InjectMocks
    private ProductDefService definitionService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(tdBProductRepository.findOne(99999830L)).thenReturn(buildProduct(99999830L, "产品名称"));
    }

    private TdBProduct buildProduct(Long id, String name) {
        TdBProduct tdBProduct = new TdBProduct();
        tdBProduct.setProductId(id);
        tdBProduct.setProductName(name);
        return tdBProduct;
    }

    @Test
    public void getProductInfo() {
        TdBProduct productInfo = definitionService.getProductInfo(99999830L);
        logger.info(productInfo.toString());
        assertEquals(productInfo.getProductId().longValue(), 99999830L);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void getProductInfoResourceNotFoundException() {
        definitionService.getProductInfo(1L);
    }
}