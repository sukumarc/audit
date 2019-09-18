package com.lti.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.SubDimension;


@Repository
public interface SubDimensionRepository extends JpaRepository<SubDimension, Integer>{
	
	List<SubDimension> findByDimensionDimensionDescription(String dimension);

}
