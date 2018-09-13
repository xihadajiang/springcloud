package com.inspur.incloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The ibase application.
 *
 * @author lvxianguo
 */
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class InspurCloudIbaseApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(InspurCloudIbaseApplication.class, args);
	}
}
