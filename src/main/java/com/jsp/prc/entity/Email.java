package com.jsp.prc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "email_Status")
@Data
public class Email {
	
	@Id
	private String emailId;
	private String emailStatus;

}
