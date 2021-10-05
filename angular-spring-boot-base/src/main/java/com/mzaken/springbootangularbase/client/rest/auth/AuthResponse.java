package com.mzaken.springbootangularbase.client.rest.auth;

import lombok.Data;

@Data
public class AuthResponse {
	
	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}

	private final String jwt;
}
