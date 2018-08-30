package com.inspur.incloud.swagger.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@RestController
@SpringBootApplication(scanBasePackages = "com.inspur.incloud.swagger")
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
	
	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello incloud swagger!";
    }
		
}
