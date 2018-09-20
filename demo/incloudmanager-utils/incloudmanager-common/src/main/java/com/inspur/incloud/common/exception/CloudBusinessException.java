package com.inspur.incloud.common.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CloudBusinessException extends Exception implements Serializable {

	private static final long serialVersionUID = 3640019041334840488L;
	
	private String msgCode;
	
	private String msg;
	
	private List<String> paramList = new ArrayList<String>();
	
	public CloudBusinessException (String msgCode, String msg, List<String> paramList, Throwable cause) {
		super(msg, cause);
		this.msgCode = msgCode;
		this.msg = msg;
		this.paramList = paramList;
	}
	
	public CloudBusinessException (String msgCode, List<String> paramList, Throwable cause) {
		super(cause.getMessage(), cause);
		this.msgCode = msgCode;
		this.msg = cause.getMessage();
		this.paramList = paramList;
	}
	
	public CloudBusinessException (String msgCode, String msg, List<String> paramList) {
		super(msg);
		this.msgCode = msgCode;
		this.msg = msg;
		this.paramList = paramList;
	}
	
	public CloudBusinessException (String msgCode, List<String> paramList) {
		super(msgCode);
		this.msgCode = msgCode;
		this.paramList = paramList;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getParamList() {
		return paramList;
	}

	public void setParamList(List<String> paramList) {
		this.paramList = paramList;
	}
	
	

}
