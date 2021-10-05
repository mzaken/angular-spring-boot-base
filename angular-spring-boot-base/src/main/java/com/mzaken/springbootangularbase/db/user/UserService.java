package com.mzaken.springbootangularbase.db.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mzaken.springbootangularbase.infra.security.AppRoleEnum;
import com.mzaken.springbootangularbase.infra.security.exception.NotPermittedApiException;

@Service
public class UserService {

	public void checkPermission(AppRoleEnum[] allowedRoles) throws Exception {
		AppUser appUser = getCurrentUser();
		
		boolean isOk = false;
		for (AppRoleEnum appRoleEnum : allowedRoles) {
			if (appUser.userHasRole(appRoleEnum)) {
				isOk = true;
				break;
			}
		}
		if (!isOk) {
			throw new NotPermittedApiException();
		}
	}

	public AppUser getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails)principal;
		AppUser appUser = mapUserDetailsToAppUser(user);
		return appUser;
	}

	private AppUser mapUserDetailsToAppUser(UserDetails user) {
		AppUser appUser = new AppUser(user);
		for (AppRoleEnum role: AppRoleEnum.values()) {
			if (user.getAuthorities().contains(role)) {
				appUser.addRole(role);
			}
		}
		return appUser;
	}
}