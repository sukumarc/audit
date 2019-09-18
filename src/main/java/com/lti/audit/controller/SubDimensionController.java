package com.lti.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.SubDimension;
import com.lti.audit.services.SubDimensionService;

@RestController
@CrossOrigin(origins = "*")
public class SubDimensionController {
	
	@Autowired
	private SubDimensionService subDimenstionService;
	
	/**Returns list of sub dimensions for the given dimension
	 * @param dimension
	 * @return
	 */
	@GetMapping(value="/{dimension}/subdimension", produces="application/json")
	public List<SubDimension> getSubDimension(@PathVariable String dimension){
		return subDimenstionService.getSubDimension(dimension);
	}

}
