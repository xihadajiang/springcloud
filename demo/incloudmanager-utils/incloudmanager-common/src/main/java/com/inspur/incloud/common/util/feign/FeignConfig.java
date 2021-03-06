package com.inspur.incloud.common.util.feign;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignConfig implements RequestInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Bean
	public WebMvcRegistrations feignWebRegistrations() {

		return new WebMvcRegistrationsAdapter() {
			@Override
			public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
				return new FeignRequestMappingHandlerMapping();
			}
		};
	}

	private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
		@Override
		protected boolean isHandler(Class<?> beanType) {
			return super.isHandler(beanType) && !beanType.isInterface();
		}
	}

	private boolean containsIgnoreCaseKey(Set<String> set, String key) {
		for(String keySet :set) {
			if(keySet.equalsIgnoreCase(key)) {
				return true;
			}
		}
		return false;
	}
	public void apply(RequestTemplate requestTemplate) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, Collection<String>> rtHeaderMap = requestTemplate.headers();
		Set<String> rtHeaderKeySet = rtHeaderMap.keySet();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String name = headerNames.nextElement();
				String values = request.getHeader(name);
				if("Transfer-Encoding".equalsIgnoreCase(name)) {
					continue;
				}
				if (null != rtHeaderMap) {
					if (containsIgnoreCaseKey(rtHeaderKeySet, name)) {
						continue;
					}
				}
				requestTemplate.header(name, values);
			}
		}
		logger.debug("FeignClient Headers:"+rtHeaderMap.toString());
		/*
		 * Enumeration<String> bodyNames = request.getParameterNames(); StringBuffer
		 * body = new StringBuffer(); if (bodyNames != null) { while
		 * (bodyNames.hasMoreElements()) { String name = bodyNames.nextElement(); String
		 * values = request.getParameter(name);
		 * body.append(name).append("=").append(values).append("&"); } } if
		 * (body.length() != 0) { body.deleteCharAt(body.length() - 1);
		 * requestTemplate.body(body.toString()); }
		 */
	}
}
