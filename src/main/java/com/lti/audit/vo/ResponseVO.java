package com.lti.audit.vo;

import com.lti.audit.enums.QuestionaireResponse;

public class ResponseVO {
	private Integer id;
	private Integer auditDimensionId;
	private QuestionaireResponse response;
	private String remarks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAuditDimensionId() {
		return auditDimensionId;
	}
	public void setAuditDimensionId(Integer auditDimensionId) {
		this.auditDimensionId = auditDimensionId;
	}
	public QuestionaireResponse getResponse() {
		return response;
	}
	public void setResponse(QuestionaireResponse response) {
		this.response = response;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
