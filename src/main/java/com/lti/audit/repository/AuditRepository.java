package com.lti.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.Audit;


@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer>  { 
	
	public Audit findById(int id);
	
	public List<Audit> findAll();

	public List<Audit> findByProjectId(Integer projectId);

}
