package com.mzaken.springbootangularbase.business;

import com.mzaken.springbootangularbase.db.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mzaken.springbootangularbase.client.dto.UserDto;
import com.mzaken.springbootangularbase.client.rest.RestResponse;
import com.mzaken.springbootangularbase.client.rest.RestResponseFactory;
import com.mzaken.springbootangularbase.client.rest.auth.AuthRequest;
import com.mzaken.springbootangularbase.infra.security.service.AppUserDetailService;
import com.mzaken.springbootangularbase.infra.security.util.JwtUtil;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final AuthenticationManager authManager;
	
	private final AppUserDetailService userDetailsService;
	                                                                                                                                                                                          
	private final JwtUtil jwtUtil;

	private final PasswordEncoder passwordEncoder;

	private final UserService userService;

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

	public UserDto register(AuthRequest authRequest) {
		String password = passwordEncoder.encode(authRequest.getPassword());
		return userService.registerUser(authRequest.getUsername(), password);
	}
}
