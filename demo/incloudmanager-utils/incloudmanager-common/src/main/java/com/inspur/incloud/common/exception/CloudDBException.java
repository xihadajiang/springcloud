package com.inspur.incloud.common.exception;

import java.io.Serializable;

public class CloudDBException extends Exception implements Serializable  {

	private static final long serialVersionUID = -2526595886947727728L;
	
	public CloudDBException (String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public CloudDBException (String msg) {
		super(msg);
	}

}
