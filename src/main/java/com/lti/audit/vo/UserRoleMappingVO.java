package com.lti.audit.vo;

public class UserRoleMappingVO {

	private String userRoleMappingId;
	private String userName;
	private RoleVO role;
	
	public String getUserRoleMappingId() {
		return userRoleMappingId;
	}
	public void setUserRoleMappingId(String userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public RoleVO getRole() {
		return role;
	}
	public void setRole(RoleVO role) {
		this.role = role;
	}
}
