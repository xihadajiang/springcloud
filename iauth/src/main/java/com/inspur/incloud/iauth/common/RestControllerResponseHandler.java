package com.inspur.incloud.iauth.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice(annotations = RestController.class)
public class RestControllerResponseHandler implements ResponseBodyAdvice<Object> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerResponseHandler.class);
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		// 对body进行封装处理
		ObjectMapper mapper = new ObjectMapper();
        String json = "";
        RestResult<Object> result = RestResult.newInstance();
        if (body instanceof String) {
            String msg = (String) body;
            result.setFlag(true);
            result.setResData(msg);
            
        } else if (body instanceof Object) {
            Object data = (Object) body;
            result.setFlag(true);
            result.setResData(data);
        }
        try {
			json = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
		}
        return json;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
		return true;
	}
}