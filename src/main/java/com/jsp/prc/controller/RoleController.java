package com.jsp.prc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.prc.entity.Role;
import com.jsp.prc.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	public ResponseEntity<Role> createRole(Role role){
		return new ResponseEntity<Role>(roleService.createRole(role),HttpStatus.CREATED);
	}
	
	public ResponseEntity<Role> findRoleById(@RequestParam String rid){
		return new ResponseEntity<Role>(roleService.findRoleById(rid),HttpStatus.OK);
	}
	
	public ResponseEntity<List<Role>> findAllRoles(){
		return new ResponseEntity<List<Role>>(roleService.findAllRoles(),HttpStatus.OK);
	}
	
	public ResponseEntity<Role> updateRole(@RequestParam String rid,@RequestBody Role role){
		return new ResponseEntity<Role>(roleService.updateService(rid,role),HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteRole(@RequestParam String rid){
		return new ResponseEntity<String>(roleService.deleteService(rid),HttpStatus.OK);
	}

}
