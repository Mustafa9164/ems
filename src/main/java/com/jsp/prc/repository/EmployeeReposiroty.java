package com.jsp.prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.prc.entity.Employee;

public interface EmployeeReposiroty extends JpaRepository<Employee, String> {

	@Query("SELECT e FROM Employee e WHERE e.email = ?1 And e.password = ?2") 
	Employee login(String email, String password);

}
