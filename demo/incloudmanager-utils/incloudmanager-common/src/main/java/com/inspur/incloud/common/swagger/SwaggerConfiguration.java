package com.inspur.incloud.common.swagger;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ResponseMessage;
/**
 * This class will generate the Swagger documentation for your application.
 */
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
@Configuration
public class SwaggerConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket documentation() {
    	List<ResponseMessage> responseMessages = Arrays.asList( );
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.inspur.incloud"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                .pathMapping("/")
                .protocols(Sets.newHashSet("http", "https"))
                .apiInfo(apiInfo()).enable(swaggerProperties.isEnable());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .termsOfServiceUrl(swaggerProperties.getTermsPath())
                .contact(new Contact("", "", swaggerProperties.getEmail()))
                .license(swaggerProperties.getLicenceType())
                .licenseUrl(swaggerProperties.getLicencePath())
                .version(swaggerProperties.getVersion())
                .build();
    }


}