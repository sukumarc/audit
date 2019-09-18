package com.lti.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.AuditRole;

@Repository
public interface AuditRoleRepository extends JpaRepository<AuditRole, Long> {
	
	AuditRole findByRoleCode(String roleCode);

}
