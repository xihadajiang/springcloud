package com.inspur.incloud.common;

public class OperationResult<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean flag;
	
	private String errCode;
	
	private String errMessage;
	
	private T resData;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public T getResData() {
		return resData;
	}

	public void setResData(T resData) {
		this.resData = resData;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	@Override
	public String toString() {
		return "OperationResult [flag=" + flag + ", errCode=" + errCode
				+ ", errMessage=" + errMessage + ", resData=" + resData + "]";
	}

}
