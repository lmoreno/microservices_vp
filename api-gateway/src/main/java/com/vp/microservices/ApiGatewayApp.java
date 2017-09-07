package com.vp.microservices;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableZuulProxy
public class ApiGatewayApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApp.class).web(true).run(args);
    }
}
