package com.lti.audit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GenericGenerator(name = "sequence_id", strategy = "com.lti.audit.generator.QuestionGenerator")
	@GeneratedValue(generator = "sequence_id") 
	private Integer id;
	
//	cascade = CascadeType.ALL
	@ManyToOne
	@JoinColumn(name="sub_dimension_id")
	private SubDimension subDimension;
	
	@Column(length=1000,name="question_description")
	private String questionDescription;
	
	@Column
	@Type(type="yes_no")
	private boolean isActive;

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SubDimension getSubDimension() {
		return subDimension;
	}

	public void setSubDimension(SubDimension subDimension) {
		this.subDimension = subDimension;
	}

	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
