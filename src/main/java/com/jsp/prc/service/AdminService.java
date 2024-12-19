package com.jsp.prc.service;

import com.jsp.prc.entity.Employee;

public interface AdminService {

	String login(String aemail, String apassword);

	Employee createEmployee(Employee employee);

	Employee editEmployee(Employee employee, String eid);

	Boolean removeEmployee(String eid);
}
