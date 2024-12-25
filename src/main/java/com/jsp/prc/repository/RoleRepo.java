package com.jsp.prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.prc.entity.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

}
