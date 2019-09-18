package com.lti.audit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.SubDimension;
import com.lti.audit.repository.SubDimensionRepository;


@Service
public class SubDimensionService {
	
	@Autowired
	private SubDimensionRepository subDimensionRepository;

	public List<SubDimension> getSubDimension(String dimension){
		return subDimensionRepository.findByDimensionDimensionDescription(dimension);
	}
	
	public SubDimension getSubDimensionById(Integer dimensionId){
		return subDimensionRepository.findById(dimensionId).get();
	}
	
}
