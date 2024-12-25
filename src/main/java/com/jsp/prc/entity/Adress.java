package com.jsp.prc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Adress {
	
	@Id
	private String aid;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;

}
