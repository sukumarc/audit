package com.lti.audit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.Audit;
import com.lti.audit.entities.AuditDimension;
import com.lti.audit.services.AuditService;
import com.lti.audit.vo.AuditVo;

@RestController
@CrossOrigin(origins = "*")
public class AuditController {

	@Autowired
	private AuditService auditService;

	/**
	 * Returns the list of audits for the selected project
	 * 
	 * @param projectId
	 * @return
	 */
	@GetMapping(value = "/project/{projectId}/audit")
	public List<Audit> getAuditsByProjectId(@PathVariable Integer projectId) {
		return auditService.getAuditsByProjectId(projectId);
	}

	@GetMapping(value = "/audit/{id}")
	public Audit getAuditDetailsById(@PathVariable Integer id) {
		return auditService.findById(id);
	}

	@PostMapping(value = "/audit")
	public Map<String, String> saveAudit(@RequestBody AuditVo auditVO) {
		Map<String, String> returnMap = new HashMap<>();
		auditService.initiateAudit(auditVO);
		returnMap.put("message", "Audit created sucessfully");
		return returnMap;
	}

	@PutMapping(value = "/audit/{id}")
	public void updateAudit(@RequestBody AuditVo auditVO, @PathVariable Integer auditId) {
		auditVO.setAuditId(auditId);
		auditService.updatedAudit(auditVO);
	}

	@DeleteMapping(value = "/audit/{id}")
	public void deleteAudit(@PathVariable Integer id) {
		auditService.deleteAudit(id);
	}

	@GetMapping(value = "/{loggedUser}/audits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<AuditDimension> getListofAuditsForAuditee(@PathVariable String loggedUser) {
		return auditService.getAuditsForAuditee(loggedUser);
	}

}