package com.mzaken.springbootangularbase.infra.security;

import org.springframework.security.core.GrantedAuthority;

public enum AppRoleEnum implements GrantedAuthority {
	ADMIN, USER;

	@Override
	public String getAuthority() {
		return this.name();
	}
}
