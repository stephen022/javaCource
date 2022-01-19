package org.javacourse.nio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NioGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NioGatewayApplication.class, args);
    }

}
