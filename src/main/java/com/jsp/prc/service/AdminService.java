package com.jsp.prc.service;

import java.util.List;
import com.jsp.prc.entity.Employee;
import com.jsp.prc.entity.Project;

public interface AdminService {

	String login(String aemail, String apassword);

	Employee createEmployee(Employee employee);

	Employee editEmployee(Employee employee, String eid);

	Boolean removeEmployee(String eid);

	Employee findEmpById(String eid);

	List<Employee> findAllEmp();

	Project findProjectById(String pid);

	List<Project> findAllProject();
}
