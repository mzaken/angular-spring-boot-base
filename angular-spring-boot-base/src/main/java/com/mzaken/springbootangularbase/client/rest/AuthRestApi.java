package com.mzaken.springbootangularbase.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzaken.springbootangularbase.business.AuthService;
import com.mzaken.springbootangularbase.client.dto.UserDto;
import com.mzaken.springbootangularbase.client.rest.auth.AuthRequest;

@RestController
@RequestMapping()
public class AuthRestApi {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public RestResponse<UserDto> auth(@RequestBody AuthRequest authRequest) {
		try {
			UserDto user = authService.authenticate(authRequest);
			return RestResponseFactory.getSuccess(user);
		} catch (Exception e) {
			e.printStackTrace();
			return RestResponseFactory.getFail("Could not authenticate, Exception: " + e.getMessage());
		}
	}

	@PostMapping("/register")
	public RestResponse<UserDto> register(@RequestBody AuthRequest authRequest) {
		try {
			UserDto user = authService.register(authRequest);
			return RestResponseFactory.getSuccess(user);
		} catch (Exception e) {
			e.printStackTrace();
			return RestResponseFactory.getFail("Could not authenticate, Exception: " + e.getMessage());
		}
	}

}
