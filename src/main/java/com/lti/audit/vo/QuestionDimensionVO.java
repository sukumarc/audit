package com.lti.audit.vo;

public class QuestionDimensionVO {
	
	private String questionDescription;
	private boolean isActive;
	private Integer subDimensionId;
	private String subDimensionDescription;
	private String dimensionDescription;
	
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Integer getSubDimensionId() {
		return subDimensionId;
	}
	public void setSubDimensionId(Integer subDimensionId) {
		this.subDimensionId = subDimensionId;
	}
	
	public String getSubDimensionDescription() {
		return subDimensionDescription;
	}
	public void setSubDimensionDescription(String subDimensionDescription) {
		this.subDimensionDescription = subDimensionDescription;
	}
	public String getDimensionDescription() {
		return dimensionDescription;
	}
	public void setDimensionDescription(String dimensionDescription) {
		this.dimensionDescription = dimensionDescription;
	}

}
