package com.jsp.prc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.prc.entity.Employee;
import com.jsp.prc.entity.Project;
import com.jsp.prc.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestParam String aemail,@RequestParam String apassword){
		return new ResponseEntity<String>(adminService.login(aemail, apassword),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(adminService.createEmployee(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("edit")
	public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee,@RequestParam String eid){
		return new ResponseEntity<Employee>(adminService.editEmployee(employee,eid),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("remove")
	public ResponseEntity<Boolean> removeEmployee(@RequestParam String eid){
		return new ResponseEntity<Boolean>(adminService.removeEmployee(eid),HttpStatus.OK);
	}
	
	@GetMapping("/byId")
	public ResponseEntity<Employee> findEmpById(@RequestParam String eid){
		return new ResponseEntity<Employee>(adminService.findEmpById(eid),HttpStatus.OK);
	}
	
	@GetMapping("/allEmp")
	public ResponseEntity<List<Employee>> findAllEmp(){
		return new ResponseEntity<List<Employee>>(adminService.findAllEmp(),HttpStatus.OK);
	}
	
	@GetMapping("/projById")
	public ResponseEntity<Project> findProjectById(@RequestParam String pid){
		return new ResponseEntity<Project>(adminService.findProjectById(pid),HttpStatus.OK);
	}
	
	@GetMapping("/allProj")
	public ResponseEntity<List<Project>> findAllProject(){
		return new ResponseEntity<List<Project>>(adminService.findAllProject(),HttpStatus.OK);
	}

}
