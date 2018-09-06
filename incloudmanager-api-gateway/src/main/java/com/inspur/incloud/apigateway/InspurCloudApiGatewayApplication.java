package com.inspur.incloud.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class InspurCloudApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(InspurCloudApiGatewayApplication.class, args);
    }
}
