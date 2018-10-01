package com.inspur.incloud.common.message.errorcode;

import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class ErrorCodeMessageUtil {
	
	private static MessageSource messageSource;
	
	private static MessageSource initMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(ErrorCodeMessageConfig.getBasename());
		messageSource.setDefaultEncoding(ErrorCodeMessageConfig.getEncoding());
		return messageSource;
	}

	public static String getMessage(String code, List<String> params, String lang) {
		if (null == messageSource) {
			messageSource = initMessageSource();
		}
		Locale locale = null;
		if ("en_US".equals(lang)) {
			locale = Locale.US;
		} else if ("zh_CN".equals(lang)) {
			locale = Locale.SIMPLIFIED_CHINESE;
		} else {
			locale = Locale.getDefault();
		}
		String result = null;
		try {
			if (null != params){
				result = messageSource.getMessage(code, params.toArray(), locale);
			} else {
				result = messageSource.getMessage(code, null, locale);
			}
			
		} catch (NoSuchMessageException e) {
			return null;
		}
		return result;

	}
}
