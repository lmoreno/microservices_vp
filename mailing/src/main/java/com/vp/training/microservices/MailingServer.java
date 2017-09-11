package com.vp.training.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MailingServer {

    public static void main(String[] args) {
        SpringApplication.run(MailingServer.class, args);
    }
}
