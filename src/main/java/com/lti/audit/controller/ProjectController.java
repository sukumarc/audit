package com.lti.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.Project;
import com.lti.audit.services.ProjectService;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * Returns the list of projects for the logged in manager
	 * @param managerId
	 * @return
	 */
	@GetMapping(value="/project/{managerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Project> getProject(@PathVariable Integer managerId) {
		return projectService.getListOfProjectsByProjMgr(managerId);
	}

}
