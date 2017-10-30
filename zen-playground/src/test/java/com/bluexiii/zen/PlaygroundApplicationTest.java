package com.bluexiii.zen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bluexiii on 25/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDiscoveryClient
public class PlaygroundApplicationTest {
    @Test
    public void main() throws Exception {
        SpringApplication springApplication = new SpringApplication();
    }
}