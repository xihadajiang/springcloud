package com.inspur.incloud.common;

public class OperationResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean flag;
	
	private String errCode;
	
	private String errMessageZh;
	
	private String errMessageEn;
	
	private Object resData;

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

	public String getErrMessageZh() {
		return errMessageZh;
	}

	public void setErrMessageZh(String errMessageZh) {
		this.errMessageZh = errMessageZh;
	}

	public String getErrMessageEn() {
		return errMessageEn;
	}

	public void setErrMessageEn(String errMessageEn) {
		this.errMessageEn = errMessageEn;
	}

	public Object getResData() {
		return resData;
	}

	public void setResData(Object resData) {
		this.resData = resData;
	}

	@Override
	public String toString() {
		return "OperationResult [flag=" + flag + ", errCode=" + errCode
				+ ", errMessageZh=" + errMessageZh + ", errMessageEn="
				+ errMessageEn + ", resData=" + resData + "]";
	}

}
