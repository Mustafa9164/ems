package com.jsp.prc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.prc.entity.Role;
import com.jsp.prc.repository.RoleRepo;
import com.jsp.prc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role findRoleById(String rid) {
		Optional<Role> optional = roleRepo.findById(rid);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Role> findAllRoles() {
		return roleRepo.findAll();
	}

	@Override
	public Role updateService(String rid, Role role) {
		Optional<Role> optional = roleRepo.findById(rid);
		if(optional.isPresent()) {
			role.setRid(rid);
			return roleRepo.save(role);
		}
		return null;
	}

	@Override
	public String deleteService(String rid) {
		Optional<Role> optional = roleRepo.findById(rid);
		if(optional.isPresent()) {
			roleRepo.deleteById(rid);
			return "Role deleted";
		}
		return "Role Not Found";
	}

}
