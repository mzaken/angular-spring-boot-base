package com.mzaken.springbootangularbase.client.rest;

import lombok.Data;

@Data
public class RestResponse<T> {

	private boolean isSuccess;
	private T payload;
	private String errorDescription;
	
	public RestResponse(boolean isSuccess, T payload, String errorDescription) {
		super();
		this.isSuccess = isSuccess;
		this.payload = payload;
		this.errorDescription = errorDescription;
	}

	public RestResponse() {
		super();
	}
}
