package com.mzaken.springbootangularbase.db.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mzaken.springbootangularbase.db.RoleEntity;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	private Long id;
	
	private String username;
	
	private String password;
	
	@ManyToMany
	private List<RoleEntity> roles;
}
