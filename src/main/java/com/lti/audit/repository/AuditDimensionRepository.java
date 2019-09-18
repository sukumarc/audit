package com.lti.audit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.AuditDimension;
import com.lti.audit.entities.User;


@Repository
public interface AuditDimensionRepository extends CrudRepository<AuditDimension, Long>  { 
	
	List<AuditDimension> findByAuditee(User user);
	
	AuditDimension findByAuditIdAndDimensionId(Integer auditId, Integer dimensionId);
}


