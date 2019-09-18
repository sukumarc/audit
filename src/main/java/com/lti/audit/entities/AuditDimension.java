package com.lti.audit.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lti.audit.enums.AuditStatus;

@Entity
public class AuditDimension {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="AUDIT_ID")
	private Audit audit;
	
	@ManyToOne
	@JoinColumn(name="DIMENSION_ID")
	private Dimension dimension;
	
	@ManyToOne
	@JoinColumn(name="AUDITEE")
	private User auditee;
	
	@Enumerated(EnumType.STRING)
	private AuditStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public User getAuditee() {
		return auditee;
	}

	public void setAuditee(User auditee) {
		this.auditee = auditee;
	}

	public AuditStatus getStatus() {
		return status;
	}

	public void setStatus(AuditStatus status) {
		this.status = status;
	}

}
