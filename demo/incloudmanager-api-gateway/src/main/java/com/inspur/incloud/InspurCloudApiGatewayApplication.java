package com.inspur.incloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.inspur.incloud.apigateway.Filter.IncloudZuulFilter;

@EnableZuulProxy
@SpringCloudApplication
@EnableFeignClients
public class InspurCloudApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(InspurCloudApiGatewayApplication.class, args);
    }
    
    @Bean
    public IncloudZuulFilter incloudZuulFilter() {
        return new IncloudZuulFilter();
    }
}
