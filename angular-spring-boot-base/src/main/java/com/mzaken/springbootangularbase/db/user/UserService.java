package com.mzaken.springbootangularbase.db.user;

import java.util.List;
import java.util.Optional;

import com.mzaken.springbootangularbase.client.dto.UserDto;
import com.mzaken.springbootangularbase.client.dto.mapper.UserMapper;
import com.mzaken.springbootangularbase.db.RoleEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mzaken.springbootangularbase.db.UserRepository;
import com.mzaken.springbootangularbase.infra.security.AppRoleEnum;
import com.mzaken.springbootangularbase.infra.security.exception.NotPermittedApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepo;
	
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
		return mapUserDetailsToAppUser(user);
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

	public boolean authenticateUser(String username, String password) {
		 Optional<UserEntity> user = userRepo.findByUsernameIgnoreCase(username);
		 if (user.get() != null && user.get().getPassword().equals(password)) {
			 return true;
		 }
		 return false;
	}

	public UserDto registerUser(String username, String password) {
		UserEntity user = new UserEntity();
		user.setUsername(username);
		user.setPassword(password);
		RoleEntity role = new RoleEntity();
		role.setActive(true);
		role.setDescription("User role");
		role.setName(AppRoleEnum.USER.getAuthority());
		role.setId(1l);
		user.setRoles(List.of(role));

		return UserMapper.INSTANCE.toDto(this.userRepo.save(user));
	}
}
