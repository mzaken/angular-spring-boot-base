package com.mzaken.springbootangularbase.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzaken.springbootangularbase.client.rest.auth.AuthRequest;
import com.mzaken.springbootangularbase.client.rest.auth.AuthResponse;
import com.mzaken.springbootangularbase.infra.security.service.AppUserDetailService;
import com.mzaken.springbootangularbase.infra.security.util.JwtUtil;

@RestController
@RequestMapping(value = Endpoints.AUTH)
public class AuthRestApi {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private AppUserDetailService userDetailsService;
	                                                                                                                                                                                          
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping()
	public RestResponse<?> auth(@RequestBody AuthRequest authRequest) {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			return RestResponseFactory.getFail("bad credentials");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		return RestResponseFactory.getSuccess(new AuthResponse(jwt));
	}
}
