package com.mzaken.springbootangularbase.client.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mzaken.springbootangularbase.db.user.UserService;
import com.mzaken.springbootangularbase.security.exception.NotPermittedApiException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiRequestHandler {

	@Autowired 
	private UserService userService; 
	
	private static UserService _userService;
	
	@PostConstruct
	public void init() {
		ApiRequestHandler._userService = userService;
	}
	
	public static <T> RestResponse<T> handleApiRequest(BusinessLogic<T> businessLogic, AppRoleEnum ...roles) {
		try {
			if (roles != null && roles.length > 0) {
				_userService.checkPermission(roles);
			}
			
			T res = businessLogic.perform(_userService.getCurrentUser());
			return RestResponseFactory.getSuccess(res);
		} catch (Exception e) {
			String msg = null;
			if (e instanceof NotPermittedApiException) {
				msg = "User not permitted";
			} else {
				msg = e.getMessage();
			}
			
			log.error(msg);
			RestResponse<T> res = RestResponseFactory.getFail(msg);
			return res;
		}
	}
}
