package com.mzaken.springbootangularbase.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mzaken.springbootangularbase.db.user.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsernameIgnoreCase(String username);

}
