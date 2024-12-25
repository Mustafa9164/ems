package com.jsp.prc.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.jsp.prc.entity.Role;

public interface RoleService {

	Role createRole(Role role);

	Role findRoleById(String rid);

	List<Role> findAllRoles();

	Role updateService(String rid, Role role);

	String deleteService(String rid);

}
