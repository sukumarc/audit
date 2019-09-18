package com.lti.audit.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lti.audit.enums.AuditFrequency;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private User manager;
	
	@Enumerated(EnumType.STRING)
	private AuditFrequency frequency;
	
	@JsonIgnore
	@OneToMany(mappedBy="project")
	private Set<Audit> audits;

	public Set<Audit> getAudits() {
		return audits;
	}

	public void setAudits(Set<Audit> audits) {
		this.audits = audits;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public AuditFrequency getFrequency() {
		return frequency;
	}

	public void setFrequency(AuditFrequency frequency) {
		this.frequency = frequency;
	}
}
