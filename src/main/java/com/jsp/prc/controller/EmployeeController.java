package com.jsp.prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.prc.entity.Employee;
import com.jsp.prc.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@GetMapping("/login")
	public ResponseEntity<String> EmployeeLogin(String email,String password){
		return new ResponseEntity<String>(employeeService.emplogin(email,password),HttpStatus.OK);
	}
	

}
