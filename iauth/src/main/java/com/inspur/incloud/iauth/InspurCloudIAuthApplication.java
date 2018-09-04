package com.inspur.incloud.iauth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The iauth application.
 *
 * @author lvxianguo
 */

@EnableDiscoveryClient
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
	
//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.inspur.incloud.iauth.controller"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//	
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("iauth模块api文档")
//				.description("iauth模块api文档")
//				.termsOfServiceUrl("http://www.iauth.com")
//				.version("1.0")
//				.build();
//	}
	
}
