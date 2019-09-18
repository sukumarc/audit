package com.lti.audit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.Question;
import com.lti.audit.entities.SubDimension;
import com.lti.audit.enums.QuestionaireResponse;
import com.lti.audit.repository.QuestionRepository;
import com.lti.audit.vo.QuestionDimensionVO;

@Service
public class QuestionService {
	
	@Autowired
	public QuestionRepository questionsRepository;
	
	@Autowired
	public SubDimensionService subDimensionService;
	
	public List<Question> findByDimensionId(int dimensionId) {
		return questionsRepository.findBySubDimensionDimensionId(dimensionId);
	}
	
	public Question findById(int questionId) {
		return questionsRepository.findById(questionId).get();
	}
	
	public List<Question> getAllQuestions(){
		List<Question> findAll = questionsRepository.findAll();
		return findAll;
	}
	
	public List<String> getOptions() {
		List<String> options = new ArrayList<>();
		options.add(QuestionaireResponse.YES.toString());
		options.add(QuestionaireResponse.NO.toString());
		options.add(QuestionaireResponse.NA.toString());
		return options;
	}
	
	public List<Question> saveQuestions(List<Question> questions) {
		return questionsRepository.saveAll(questions);
	}

	public Question addQuestion(QuestionDimensionVO questionDimensionVO) {
		
		SubDimension subDimension = subDimensionService.getSubDimensionById(questionDimensionVO.getSubDimensionId());
		if(subDimension == null) {
			throw new RuntimeException();
		}
		
		Question question = new Question();
		question.setQuestionDescription(questionDimensionVO.getQuestionDescription());
		question.setActive(questionDimensionVO.isActive());
		question.setSubDimension(subDimension);
		
		return questionsRepository.save(question);
	}
	
	
	public Question updateQuestion(Integer id, QuestionDimensionVO questionDimensionVO) {

		Question question = findById(id);
		if(question == null) {
			throw new RuntimeException();
		}
		question.setQuestionDescription(questionDimensionVO.getQuestionDescription());
		question.setActive(questionDimensionVO.isActive());
		
		SubDimension subDimension = subDimensionService.getSubDimensionById(questionDimensionVO.getSubDimensionId());
		if(subDimension == null) {
			throw new RuntimeException();
		}
		
		question.setSubDimension(subDimension);
		
		return questionsRepository.save(question);
	}
	
	public void deleteQuestion(Integer id) {
		questionsRepository.deleteById(id);
	}
}
