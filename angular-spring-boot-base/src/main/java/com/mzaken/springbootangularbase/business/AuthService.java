package com.mzaken.springbootangularbase.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.mzaken.springbootangularbase.client.dto.UserDto;
import com.mzaken.springbootangularbase.client.rest.RestResponse;
import com.mzaken.springbootangularbase.client.rest.RestResponseFactory;
import com.mzaken.springbootangularbase.client.rest.auth.AuthRequest;
import com.mzaken.springbootangularbase.infra.security.service.AppUserDetailService;
import com.mzaken.springbootangularbase.infra.security.util.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private AppUserDetailService userDetailsService;
	                                                                                                                                                                                          
	@Autowired
	private JwtUtil jwtUtil;
	
	public UserDto authenticate(AuthRequest authRequest) throws BadCredentialsException {
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		final String jwt = jwtUtil.generateToken(authRequest.getUsername());
		UserDto user = new UserDto();
		user.setToken(jwt);
		user.setUsername(authRequest.getUsername());
		//get roles for user
		
		return user;
	}
}
