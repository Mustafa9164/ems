package com.jsp.prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.prc.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

}
