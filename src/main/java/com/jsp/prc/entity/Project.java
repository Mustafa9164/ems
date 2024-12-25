package com.jsp.prc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Project {
	
	@Id
	private String pid;
	private String projectName;
	private String manager;
	private String clientName;
	private String domain;
	
	@JsonIgnore
	@ManyToMany
	private List<Employee> employees;
}
