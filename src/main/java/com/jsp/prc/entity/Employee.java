package com.jsp.prc.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@JsonIgnore
	@ManyToMany(mappedBy ="employees")
	private List<Project> projects;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
//	@JsonIgnore
//	private Leave leave;
	
	
}
