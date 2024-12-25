package com.jsp.prc.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "leave_records")
public class Leave {
	
	@Id
	private String lid;
	private String leaveType; 
	private String eid;
	private String mid;
	private String hid;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; 
    private String reason;
    private String approvalStatus;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;
}
