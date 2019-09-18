package com.lti.audit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.Project;
import com.lti.audit.exception.ProjectNotFoundException;
import com.lti.audit.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getListOfProjectsByProjMgr(Integer managerId) 
	{		
		List<Project> projectList =  projectRepository.findByManagerId(managerId);		
		
		if(projectList.isEmpty()) {
			throw new ProjectNotFoundException("Project is not found");
		}
		return projectList;
	}	
	
}