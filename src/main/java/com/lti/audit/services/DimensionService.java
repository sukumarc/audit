package com.lti.audit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.Dimension;
import com.lti.audit.repository.DimensionRepository;
import com.lti.audit.vo.QuestionDimensionVO;


@Service
public class DimensionService {
	
	@Autowired
	private DimensionRepository dimensionRepository;
	
	public List<Dimension> getDimensions(){
		return dimensionRepository.findAll();
	}
	
	public Dimension getById(Integer id){
		return dimensionRepository.findById(id).get();
	}

	public void addDimension(QuestionDimensionVO questionDimensionVO) {
		Dimension dimension =  new Dimension();
		dimension.setDimensionDescription(questionDimensionVO.getDimensionDescription());
		dimensionRepository.save(dimension);
	}
	
	public void updateDimension(Integer id, QuestionDimensionVO questionDimensionVO) {
		Dimension dimension = getById(id);
		dimension.setDimensionDescription(questionDimensionVO.getDimensionDescription());
		dimensionRepository.save(dimension);
	}
	
}
