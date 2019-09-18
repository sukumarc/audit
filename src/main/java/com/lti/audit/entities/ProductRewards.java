package com.lti.audit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="project_rewards")
public class ProductRewards {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;
	
	@Column(name="IS_ENTAIL_CASHREWARD")
	@Type(type="yes_no")
	private Boolean isCashRewardEntailed;

	@Column
	private Integer awardPoints;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Boolean getIsCashRewardEntailed() {
		return isCashRewardEntailed;
	}

	public void setIsCashRewardEntailed(Boolean isCashRewardEntailed) {
		this.isCashRewardEntailed = isCashRewardEntailed;
	}

	public Integer getAwardPoints() {
		return awardPoints;
	}

	public void setAwardPoints(Integer awardPoints) {
		this.awardPoints = awardPoints;
	}
}
