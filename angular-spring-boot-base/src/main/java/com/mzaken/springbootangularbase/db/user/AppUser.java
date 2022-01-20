package com.mzaken.springbootangularbase.db.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.mzaken.springbootangularbase.infra.security.AppRoleEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppUser {
	
	public AppUser(UserDetails user) {
		userName = user.getUsername();
		password = user.getPassword();
		roles = new ArrayList<AppRoleEnum>();
	}
	private String userName;
	private String password;
	private List<AppRoleEnum> roles;
	
	public void addRole(AppRoleEnum role) {
		roles.add(role);
	}
	public boolean userHasRole(AppRoleEnum appRoleEnum) {
		return roles.contains(appRoleEnum);
	}
	
}
