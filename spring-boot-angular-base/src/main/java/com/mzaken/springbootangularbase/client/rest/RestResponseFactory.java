package com.mzaken.springbootangularbase.client.rest;

public class RestResponseFactory {

	public static <T> RestResponse<T> getSuccess() {
		return getSuccess(null);
	}
	
	public static <T> RestResponse<T> getSuccess(T payload) {
		return new RestResponse<T>(true, payload, null);
	}
	
	public static <T> RestResponse<T> getFail(String msg) {
		return new RestResponse<T>(false, null, msg);
	}
}
