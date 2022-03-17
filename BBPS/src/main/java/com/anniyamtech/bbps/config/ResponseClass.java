package com.anniyamtech.bbps.config;

public class ResponseClass {

	private String message;
	private Object Data;

	public ResponseClass() {
		super();
	}

	public ResponseClass(String message) {
		super();
		this.message = message;
	}

	public ResponseClass(String message, Object data) {
		super();
		this.message = message;
		Data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

}
