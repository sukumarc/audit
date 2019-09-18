package com.lti.audit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class User {
	
	@Id
	@GenericGenerator(name = "sequence_id", strategy = "com.lti.audit.generator.UserGenerator")
	@GeneratedValue(generator = "sequence_id") 
	private Integer id;
	
	@Column
	private String username;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="encryp_password")
	private String password;
	
	@Column(name="is_active")
	@Type(type="yes_no")
	private Boolean isActive;
	
	@ManyToOne
	private AuditRole role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public AuditRole getRole() {
		return role;
	}

	public void setRole(AuditRole role) {
		this.role = role;
	}

}
