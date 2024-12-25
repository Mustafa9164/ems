package com.jsp.prc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {
	
	@Id
	private String rid;
	private String name;
	private String description;

}
