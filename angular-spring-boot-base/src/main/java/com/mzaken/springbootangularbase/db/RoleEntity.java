package com.mzaken.springbootangularbase.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
@Data
public class RoleEntity {

	@Id
	private Long id;

	private String name;

	private String description;
	
	private Boolean active;

}
