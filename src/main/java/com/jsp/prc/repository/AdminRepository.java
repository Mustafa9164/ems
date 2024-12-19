package com.jsp.prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.prc.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	@Query("SELECT a FROM Admin a WHERE a.aemail = ?1 And a.apassword = ?2") 
	Admin adminLogin(String email,String password);
}