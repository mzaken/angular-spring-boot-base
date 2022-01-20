package com.mzaken.springbootangularbase.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ROLE")
@Data
public class RoleEntity {

	@Id
	private Long id;
	
	private String description;
	
	private Boolean activee;

}
