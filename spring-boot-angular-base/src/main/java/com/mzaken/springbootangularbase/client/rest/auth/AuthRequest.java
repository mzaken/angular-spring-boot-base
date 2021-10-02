package com.mzaken.springbootangularbase.client.rest.auth;

import lombok.Data;

@Data
public class AuthRequest {

	private String username;
	
	private String password;
}
