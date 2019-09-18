package com.lti.audit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.services.AuditDimensionResponseService;
import com.lti.audit.vo.QuestionsVO;
import com.lti.audit.vo.ResponseVO;

@RestController
@CrossOrigin(origins = "*")
public class AuditDimensionResponseController {
	
	@Autowired
	private AuditDimensionResponseService auditDimensionResponseService; 
	
	@GetMapping(value="/{auditId}/questions/{dimensionId}")
	public List<QuestionsVO> getSavedQuestionaires(@PathVariable Integer auditId, @PathVariable Integer dimensionId){
		return auditDimensionResponseService.getQuestionaries(auditId, dimensionId);
	}

	@PostMapping(value="/{auditId}/{dimensionId}/questions")
	public void submitQuestionaire(@PathVariable Integer auditId,
			@PathVariable Integer dimensionId, 
			@RequestBody Map<Integer, ResponseVO> responses) {
		auditDimensionResponseService.submitQuestions(auditId, dimensionId, responses);
	}

}