package com.mzaken.springbootangularbase.client.dto.mapper;

import com.mzaken.springbootangularbase.client.dto.UserDto;
import com.mzaken.springbootangularbase.db.RoleEntity;
import com.mzaken.springbootangularbase.db.user.UserEntity;
import com.mzaken.springbootangularbase.infra.security.AppRoleEnum;

import java.util.List;

public class UserMapper {
    public static UserMapper INSTANCE = new UserMapper();


    public UserDto toDto(UserEntity entity) {
        return UserDto.builder()
                .username(entity.getUsername())
                .roles(mapRoles(entity.getRoles()))
                .build();
    }

    private List<AppRoleEnum> mapRoles(List<RoleEntity> roles) {
        return roles.stream()
                .map(role -> AppRoleEnum.valueOf(role.getName()))
                .toList();
    }

}
