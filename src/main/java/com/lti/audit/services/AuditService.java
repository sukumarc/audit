package com.lti.audit.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.Audit;
import com.lti.audit.entities.AuditDimension;
import com.lti.audit.entities.Dimension;
import com.lti.audit.entities.Project;
import com.lti.audit.entities.User;
import com.lti.audit.enums.AuditStatus;
import com.lti.audit.repository.AuditDimensionRepository;
import com.lti.audit.repository.AuditRepository;
import com.lti.audit.repository.UserRepository;
import com.lti.audit.vo.AuditVo;
import com.lti.audit.vo.DimensionVo;

@Service
public class AuditService {
	
	@Autowired
	private AuditRepository auditRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuditDimensionRepository auditDimensionRepository;

	public Audit findById(int auditId) {
		return auditRepository.findById(auditId);
	}
	
	public List<Audit> getAuditsByProjectId(Integer projectId){
		return auditRepository.findByProjectId(projectId);
	}
	
	public void updatedAudit(AuditVo auditVO) {
		Audit audit = findById(auditVO.getAuditId());
		
		Project project = new Project();
		project.setId(auditVO.getProjectId());
		audit.setProject(project);
		
		audit.setEndDate(auditVO.getEndDate());
		audit.setStartDate(auditVO.getStartDate());
		audit.setStatus(AuditStatus.INITIATED);
		
		auditRepository.save(audit);
	}
	
	
	
	@Transactional
	public Audit initiateAudit(AuditVo auditVO) {
		
		Project project = new Project();
		project.setId(auditVO.getProjectId());
		
		Audit audit = new Audit();
		audit.setStartDate(auditVO.getStartDate());
		audit.setEndDate(auditVO.getEndDate());
		audit.setProject(project);
		audit.setStatus(AuditStatus.INITIATED);
		
		Set<AuditDimension> auditDimensionsSet = new HashSet<>(); 
		
		List<DimensionVo> dimensionAuditeeMap = auditVO.getDimensionAuditeeMap();
		
		dimensionAuditeeMap.stream().forEach(dimensionAuditee -> {
			
			AuditDimension auditDimension =  new AuditDimension();
			
			Integer userId = dimensionAuditee.getUser();
			User auditee = new User();
			auditee.setId(userId);
			auditDimension.setAuditee(auditee);
			
			Dimension dimension  = new Dimension();
			dimension.setId(dimensionAuditee.getDimension());
			auditDimension.setDimension(dimension);
			
			auditDimension.setStatus(AuditStatus.INITIATED);
			
			auditDimension.setAudit(audit);

			auditDimensionsSet.add(auditDimension);
			
		});
		
		audit.setAuditDimensions(auditDimensionsSet);
		
		return auditRepository.save(audit);
		
	}

	public List<AuditDimension> getAuditsForAuditee(String loggedUser) {
		User user = userRepository.findByUsername(loggedUser);
		List<AuditDimension> auditDimensions = auditDimensionRepository.findByAuditee(user);
		
		return auditDimensions.stream()
				.filter(auditDimension -> auditDimension.getAudit().getStatus() != AuditStatus.CLOSED)
				.collect(Collectors.toList());
	}

	public void deleteAudit(Integer auditId) {
		auditRepository.deleteById(auditId);
	}
	
}
