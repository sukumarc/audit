package com.lti.audit.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.AuditRole;
import com.lti.audit.repository.AuditRoleRepository;
import com.lti.audit.vo.RoleVO;

@Service
public class AuditRoleService {

	@Autowired
	private AuditRoleRepository auditRoleRepository;
	
	/**
	 * 
	 * @param role
	 * @return
	 */
	public AuditRole saveRole(RoleVO role) {
		
		AuditRole auditRole = new AuditRole();
		auditRole.setId(role.getId());
		auditRole.setRoleCode(role.getRoleCode());
		auditRole.setRoleName(role.getRoleName());
		auditRole.setRoleDescription(role.getRoleDescription());
		return auditRoleRepository.save(auditRole);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<RoleVO> getAuditRoles(){
		List<AuditRole> roles = auditRoleRepository.findAll();
		return roles.stream()
				.map(auditRole -> mapToRoleVO(auditRole))
				.collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @param auditRole
	 * @return
	 */
	private RoleVO mapToRoleVO(AuditRole auditRole) {
		RoleVO roleVO = new RoleVO();
		
		roleVO.setId(auditRole.getId());
		roleVO.setRoleCode(auditRole.getRoleCode());
		roleVO.setRoleDescription(auditRole.getRoleDescription());
		roleVO.setRoleName(auditRole.getRoleName());
		
		return roleVO;
	}
}
