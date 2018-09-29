package com.inspur.incloud.common.util.mvc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * The Class WebConfig.
 */
//@Configuration
//@ConditionalOnClass({ RestController.class })
public class WebConfig {
    @Bean
    public WebMvcRegistrations feignWebRegistrations() {

        return new WebMvcRegistrationsAdapter() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new MvcRestRequestMappingHandlerMapping();
            }
        };
    }

    private static class MvcRestRequestMappingHandlerMapping extends RestRequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && !beanType.isInterface();
        }
    }
	
}