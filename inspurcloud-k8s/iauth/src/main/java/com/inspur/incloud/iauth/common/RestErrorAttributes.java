package com.inspur.incloud.iauth.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

public class RestErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
    	
    	Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
	        Throwable error = getError(requestAttributes);

	        if (error == null) {
	            return defaultErrorAttributes;
	        }


	        Map<String, Object> customErrorAttributes = new HashMap<>();
	        
	        String errCode = "10"+ defaultErrorAttributes.get("status");
	        customErrorAttributes.put("flag", false);
	        customErrorAttributes.put("errCode", errCode);
	        customErrorAttributes.put("resData", error.getMessage());
	        return customErrorAttributes;
	  }


}
