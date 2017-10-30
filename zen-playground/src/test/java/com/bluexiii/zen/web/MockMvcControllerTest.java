package com.bluexiii.zen.web;

import com.bluexiii.zen.domain.TdBProduct;
import com.bluexiii.zen.service.ProductDefService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by bluexiii on 11/08/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductDefController.class)
public class MockMvcControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(MockMvcControllerTest.class);
    @Value("${custom.baseurl}")
    private String baseurl;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductDefService definitionService;

    private TdBProduct buildProduct(Long id, String name) {
        TdBProduct tdBProduct = new TdBProduct();
        tdBProduct.setProductId(id);
        tdBProduct.setProductName(name);
        return tdBProduct;
    }

    @Test
    public void getProductInfo() throws Exception {

        given(this.definitionService.getProductInfo(99999830L))
                .willReturn(buildProduct(99999830L, "产品名称"));

        mockMvc.perform(get(baseurl + "/productdefs/99999830").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(99999830L))
                .andDo(print());
    }
}