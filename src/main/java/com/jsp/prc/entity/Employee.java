package com.jsp.prc.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	private String eid;
	private String ename;
	private String email;
	private String password;
	private String pic;
	private String mid;
	private String hid;
	private String role;
	private Date doj;
	private Date dor;


}
