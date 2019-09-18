package com.lti.audit.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lti.audit.enums.AuditStatus;

@Entity
public class Audit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	private AuditStatus status;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;

	@JsonManagedReference
	@OneToMany(mappedBy="audit",cascade = CascadeType.ALL)
	private Set<AuditDimension> auditDimensions;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public AuditStatus getStatus() {
		return status;
	}

	public void setStatus(AuditStatus status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<AuditDimension> getAuditDimensions() {
		return auditDimensions;
	}

	public void setAuditDimensions(Set<AuditDimension> auditDimensions) {
		this.auditDimensions = auditDimensions;
	}
	
	
}
