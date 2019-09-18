package com.lti.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.AuditRole;
import com.lti.audit.services.AuditRoleService;
import com.lti.audit.vo.RoleVO;

@RestController
@CrossOrigin(origins = "*")
public class AuditRoleController {
	
	@Autowired
	private AuditRoleService auditRoleService;
	
	@PostMapping(value="/role")
	public ResponseEntity<Object> addRole(@RequestBody RoleVO roleVO){
		return saveOrUpdateRole(roleVO);
	}

	@PutMapping(value="/role/{roleId}")
	public ResponseEntity<Object> updateRole(@PathVariable String roleId, @RequestBody RoleVO roleVO){
		return saveOrUpdateRole(roleVO);
	}

	private ResponseEntity<Object> saveOrUpdateRole(RoleVO roleVO){
		AuditRole role = auditRoleService.saveRole(roleVO);

		if(role == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(role);
	}
	
	@GetMapping("/role")
	public ResponseEntity<List<RoleVO>> getRoles(){
		return ResponseEntity.ok(auditRoleService.getAuditRoles());
	}

}
