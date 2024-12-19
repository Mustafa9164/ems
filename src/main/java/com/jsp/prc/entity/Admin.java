package com.jsp.prc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Admin {
	
	@Id
	private String aid;
	private String aname;
	private String aemail;
	private String apassword;
	private String phone;

}
