package com.lti.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.Question;
import com.lti.audit.services.QuestionService;
import com.lti.audit.vo.QuestionDimensionVO;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionsService;
	
	@PostMapping(value="/question")
	public ResponseEntity<Object> addQuestion(@RequestBody QuestionDimensionVO questionDimensionVO){
		questionsService.addQuestion(questionDimensionVO);
		return ResponseEntity.ok(questionDimensionVO);
	}
	
	@PutMapping(value="/question/{id}")
	public ResponseEntity<Object> updateQuestion(@PathVariable Integer id, @RequestBody QuestionDimensionVO questionDimensionVO){
		questionsService.updateQuestion(id, questionDimensionVO);
		return ResponseEntity.ok(questionDimensionVO);
	}
	
	@DeleteMapping(value="/question/{id}")
	public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable Integer id){
		Question question = questionsService.findById(id);
		System.out.println(question);
		questionsService.deleteQuestion(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value="/questions/{dimensionId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> findById(@PathVariable Integer dimensionId){
		return questionsService.findByDimensionId(dimensionId);
	}
	
	@GetMapping(value="/questions")
	public ResponseEntity<List<Question>> getAllQuestion(){
		List<Question> allQuestions = questionsService.getAllQuestions();
		return ResponseEntity.ok(allQuestions);
	}

}
