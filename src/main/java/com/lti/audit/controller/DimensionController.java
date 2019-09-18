package com.lti.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.Dimension;
import com.lti.audit.services.DimensionService;
import com.lti.audit.vo.QuestionDimensionVO;

@RestController
@CrossOrigin(origins = "*")
public class DimensionController {
	
	@Autowired
	private DimensionService dimensionService;
	
	/**
	 * Returns the list of dimensions available.
	 * @return
	 */
	@GetMapping(value="/dimension", produces="application/json")
	public List<Dimension> getDimensions(){
		return dimensionService.getDimensions();
	}
	
	@PostMapping(value="/dimension")
	public ResponseEntity<Object> addDimension(@RequestBody QuestionDimensionVO questionDimensionVO){
		dimensionService.addDimension(questionDimensionVO);
		return ResponseEntity.ok(questionDimensionVO);
	}
	
	@PutMapping(value="/dimension/{id}")
	public ResponseEntity<Object> updateDimension(@PathVariable Integer id, @RequestBody QuestionDimensionVO questionDimensionVO){
		dimensionService.updateDimension(id, questionDimensionVO);
		return ResponseEntity.ok(questionDimensionVO);
	}

}
