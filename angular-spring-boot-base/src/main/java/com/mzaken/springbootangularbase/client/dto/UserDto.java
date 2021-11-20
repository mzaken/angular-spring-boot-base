package com.mzaken.springbootangularbase.client.dto;

import java.util.List;

import com.mzaken.springbootangularbase.infra.security.AppRoleEnum;

import lombok.Data;

@Data
public class UserDto {
	
	private String token;
	private String username;
	private List<AppRoleEnum> roles;
}
