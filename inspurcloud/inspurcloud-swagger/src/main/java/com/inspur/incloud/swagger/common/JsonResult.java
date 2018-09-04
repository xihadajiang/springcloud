package com.inspur.incloud.swagger.common;

import io.swagger.annotations.ApiModelProperty;

public class JsonResult {
	
	@ApiModelProperty(value = "状态", example = "OK")
	private String status = null;

	@ApiModelProperty(value = "结果", example = "success")
	private Object result = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	// Getter Setter

}
