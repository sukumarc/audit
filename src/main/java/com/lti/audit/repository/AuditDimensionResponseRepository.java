package com.lti.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.AuditDimension;
import com.lti.audit.entities.AuditDimensionResponse;


@Repository
public interface AuditDimensionResponseRepository extends JpaRepository<AuditDimensionResponse, Integer>  { 
	
	AuditDimensionResponse findByQuestionIdAndAuditDimension(Integer questionId, AuditDimension auditDimension);
	
}
