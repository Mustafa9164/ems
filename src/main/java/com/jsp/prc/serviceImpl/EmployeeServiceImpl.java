package com.jsp.prc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.prc.entity.Employee;
import com.jsp.prc.repository.EmployeeReposiroty;
import com.jsp.prc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeReposiroty employeeReposiroty;

	@Override
	public String emplogin(String email, String password) {
		 Employee login = employeeReposiroty.login(email,password);
		 if (login != null) {
			 return "Login Sucessfully";
		}
		 return "Login Failed";
	}

}
