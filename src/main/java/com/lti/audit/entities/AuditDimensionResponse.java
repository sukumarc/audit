package com.lti.audit.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lti.audit.enums.QuestionaireResponse;

@Entity
public class AuditDimensionResponse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="AUDIT_DIMENSION_ID")
	private AuditDimension auditDimension;
	
	@Enumerated(EnumType.STRING)
	private QuestionaireResponse response;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@Column
	private Blob evidence;

	@Column
	private String remarks;
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AuditDimension getAuditDimension() {
		return auditDimension;
	}

	public void setAuditDimension(AuditDimension auditDimension) {
		this.auditDimension = auditDimension;
	}

	public QuestionaireResponse getResponse() {
		return response;
	}

	public void setResponse(QuestionaireResponse response) {
		this.response = response;
	}

	public Blob getEvidence() {
		return evidence;
	}

	public void setEvidence(Blob evidence) {
		this.evidence = evidence;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
