package com.inspur.incloud.ibase.service.user.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ErrorCodeMessage {
	private MessageSource messageSource;

	@Value("${spring.errorcode.messages.basename}")
	private String basename;

	@Value("${spring.errorcode.messages.cache-seconds}")
	private long cacheMillis;

	@Value("${spring.errorcode.messages.encoding}")
	private String encoding;

	private MessageSource initMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(basename);
		messageSource.setDefaultEncoding(encoding);
		messageSource.setCacheMillis(cacheMillis);
		return messageSource;
	}

	public String getMessage(String code, List<String> params, Locale locale) {
		if (null == messageSource) {
			messageSource = initMessageSource();
		}
		String result = null;
		try {
			result = messageSource.getMessage(code, params.toArray(), locale);
		} catch (NoSuchMessageException e) {
			return null;
		}
		return result;

	}
}
