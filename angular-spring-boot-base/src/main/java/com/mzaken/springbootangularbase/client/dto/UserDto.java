package com.mzaken.springbootangularbase.client.dto;

import java.util.List;

import com.mzaken.springbootangularbase.infra.security.AppRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private String token;
	private String username;
	private List<AppRoleEnum> roles;
}
