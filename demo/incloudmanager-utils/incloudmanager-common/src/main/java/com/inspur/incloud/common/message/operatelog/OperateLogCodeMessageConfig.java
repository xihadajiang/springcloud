package com.inspur.incloud.common.message.operatelog;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Component(value = "OperateLogCodeMessageConfig")
@ConfigurationProperties(prefix = "spring.operatelog.messages")
public class OperateLogCodeMessageConfig {

	private static String basename;

	private static String encoding;

	public static String getBasename() {
		return basename;
	}

	public static String getEncoding() {
		return encoding;
	}

	@Value("${spring.errorcode.messages.basename}")
	public void setBasename(String basename) {
		OperateLogCodeMessageConfig.basename = basename;
	}

	@Value("${spring.errorcode.messages.encoding}")
	public void setEncoding(String encoding) {
		OperateLogCodeMessageConfig.encoding = encoding;
	}

}
