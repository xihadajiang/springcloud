package com.inspur.incloud.common.message.errorcode;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Component(value = "ErrorCodeMessageConfig")
@ConfigurationProperties(prefix = "spring.errorcode.messages")
public class ErrorCodeMessageConfig {

	private static String basename;

	private static String encoding;

	public static String getBasename() {
		return basename;
	}

	public static String getEncoding() {
		return encoding;
	}

	@Value("${spring.errorcode.messages.basename:'i18n/messages/errorcode/ibase_errorcode_message'}")
	public void setBasename(String basename) {
		ErrorCodeMessageConfig.basename = basename;
	}

	@Value("${spring.errorcode.messages.encoding:'UTF-8'}")
	public void setEncoding(String encoding) {
		ErrorCodeMessageConfig.encoding = encoding;
	}

}
