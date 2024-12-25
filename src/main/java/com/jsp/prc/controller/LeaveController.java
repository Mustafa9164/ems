package com.jsp.prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.prc.entity.Leave;
import com.jsp.prc.service.LeaveService;

@RestController
@RequestMapping("/leave")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	
	@PostMapping("/apply")
	public ResponseEntity<Leave> applyLeave(@RequestBody Leave leave){
		return new ResponseEntity<Leave>(leaveService.applyLeave(leave),HttpStatus.CREATED);
	}
	
	@PostMapping("/approve")
	public ResponseEntity<Leave> approveLeave(@RequestParam String lid,@RequestParam String status){
		return new ResponseEntity<Leave>(leaveService.approveLeave(lid,status),HttpStatus.OK);
	}

}
