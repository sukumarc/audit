package com.lti.audit.vo;

public class LeaderVo {
	
	private int manager_id;
	private String manager_name;
	private String project_name;
	private int award_points;
	public int getAward_points() {
		return award_points;
	}
	public void setAward_points(int award_points) {
		this.award_points = award_points;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		String mananger=manager_name+" "+".";
		this.manager_name = mananger;
	}
	public String getProject_name() {
		return project_name;
	}
	public LeaderVo(int manager_id, String manager_name, String project_name,
			int award_points) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.project_name = project_name;
		this.award_points = award_points;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
}
