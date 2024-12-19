package com.jsp.prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.prc.entity.Employee;

public interface EmployeeReposiroty extends JpaRepository<Employee, String> {

}
