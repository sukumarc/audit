package com.lti.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	List<Project> findByManagerId(Integer managerId);
	
}
