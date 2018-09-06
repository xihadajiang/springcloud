package com.inspur.incloud;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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
	
	 @Autowired
	 private EntityManagerFactory entityManagerFactory;
	 
	@Bean
	public SessionFactory getSessionFactory() {
	   if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	      throw new NullPointerException("factory is not a hibernate factory");
	   }
	   return entityManagerFactory.unwrap(SessionFactory.class);
     }
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.inspur.incloud.ibase.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("ibase模块api文档")
				.description("ibase模块api文档")
				.termsOfServiceUrl("http://www.ibase.com")
				.version("1.0")
				.build();
	}
	
}
