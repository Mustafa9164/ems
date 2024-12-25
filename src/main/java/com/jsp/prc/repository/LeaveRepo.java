package com.jsp.prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.prc.entity.Leave;

public interface LeaveRepo extends JpaRepository<Leave, String> {

}
