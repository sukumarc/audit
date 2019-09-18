package com.lti.audit.vo;

public class QuestionsVO {
	
	private Integer id;
	private String questionDescription;
	private Integer responseId;
	private String remarks;
	private String response;
	private Integer auditDimensionId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public Integer getResponseId() {
		return responseId;
	}
	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Integer getAuditDimensionId() {
		return auditDimensionId;
	}
	public void setAuditDimensionId(Integer auditDimensionId) {
		this.auditDimensionId = auditDimensionId;
	}
	
	
}
