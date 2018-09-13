package com.inspur.incloud.iauth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * The iauth application.
 *
 * @author lvxianguo
 */
/** @EnableDiscoveryClient */
@SpringBootApplication
public class InspurCloudIAuthApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(InspurCloudIAuthApplication.class, args);
	}
	
	
}
