package com.jsp.prc.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.prc.entity.Admin;
import com.jsp.prc.entity.Employee;
import com.jsp.prc.entity.Project;
import com.jsp.prc.exception.EmployeeNotFound;
import com.jsp.prc.repository.AdminRepository;
import com.jsp.prc.repository.EmployeeReposiroty;
import com.jsp.prc.repository.ProjectRepository;
import com.jsp.prc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeReposiroty employeeReposiroty;
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public String login(String aemail, String apassword) {
		 Admin adminLogin = adminRepository.adminLogin(aemail, apassword);
		 if(adminLogin != null) {
			 return "Admin Login Sucessfully";
		 }
		 return "Not found!";
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = employeeReposiroty.save(employee);
		if(emp != null) {
			return emp;
		}
		return null;
	}

	@Override
	public Employee editEmployee(Employee employee, String eid) {
		Optional<Employee> optional = employeeReposiroty.findById(eid);
		if(optional.isPresent()) {
			employee.setEid(eid);
			return employeeReposiroty.save(employee);
		}
		throw new EmployeeNotFound("Employee Not Found with ");
	}

	@Override
	public Boolean removeEmployee(String eid) {
		 Optional<Employee> optional = employeeReposiroty.findById(eid);
		 if(optional.isPresent()) {
			 employeeReposiroty.deleteById(eid);
			 return true;
		 }
			throw new EmployeeNotFound("Employee Not Found with ");
	}

	@Override
	public Employee findEmpById(String eid) {
		 Optional<Employee> optional = employeeReposiroty.findById(eid);
		 if(optional != null) {
			 return optional.get();
		 }
		 return null;
	}

	@Override
	public List<Employee> findAllEmp() {
		return employeeReposiroty.findAll();
	}

	@Override
	public Project findProjectById(String pid) {
		Optional<Project> optional = projectRepository.findById(pid);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}

}
