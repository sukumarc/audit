package com.lti.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.audit.entities.Dimension;

@Repository
public interface DimensionRepository extends JpaRepository<Dimension, Integer>{

}
