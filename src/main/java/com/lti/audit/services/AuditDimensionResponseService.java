package com.lti.audit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.AuditDimension;
import com.lti.audit.entities.AuditDimensionResponse;
import com.lti.audit.entities.Question;
import com.lti.audit.repository.AuditDimensionRepository;
import com.lti.audit.repository.AuditDimensionResponseRepository;
import com.lti.audit.repository.QuestionRepository;
import com.lti.audit.vo.QuestionsVO;
import com.lti.audit.vo.ResponseVO;

@Service
public class AuditDimensionResponseService {

	@Autowired
	private AuditDimensionResponseRepository auditDimensionResponseRepository;
	
	@Autowired
	private AuditDimensionRepository auditDimensionRepository;
	
	@Autowired
	private QuestionRepository questionsRepository;
	
	/**
	 * 
	 * @param auditId
	 * @param dimensionId
	 * @param questions
	 */
	public void submitQuestions(Integer auditId, Integer dimensionId, 
			Map<Integer, ResponseVO> questions) {

		List<AuditDimensionResponse> responsesList = new ArrayList<>();
		
		AuditDimension auditDimension = auditDimensionRepository
				.findByAuditIdAndDimensionId(auditId, dimensionId);

		questions.keySet().forEach(questionId -> {

			ResponseVO vo = questions.get(questionId);
			
			AuditDimensionResponse auditDimensionResponse = auditDimensionResponseRepository
									.findByQuestionIdAndAuditDimension(questionId, auditDimension);
			
			if(auditDimensionResponse == null) {
				auditDimensionResponse = new AuditDimensionResponse();
			}
			auditDimensionResponse.setRemarks(vo.getRemarks());
			auditDimensionResponse.setResponse(vo.getResponse());
			auditDimensionResponse.setAuditDimension(auditDimension);
			
			Question question = new Question();
			question.setId(questionId);
			auditDimensionResponse.setQuestion(question);
			
			responsesList.add(auditDimensionResponse);

		});
		auditDimensionResponseRepository.saveAll(responsesList);
	}
	

	/**
	 * 
	 * @param auditId
	 * @param dimensionId
	 * @return
	 */
	public List<QuestionsVO> getQuestionaries(Integer auditId, Integer dimensionId) {

		AuditDimension auditDimension = auditDimensionRepository.findByAuditIdAndDimensionId(auditId, dimensionId);
		
		return questionsRepository.getQuestions(auditDimension.getId());
	}
}
