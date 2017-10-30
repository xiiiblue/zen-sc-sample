package com.bluexiii.zen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
