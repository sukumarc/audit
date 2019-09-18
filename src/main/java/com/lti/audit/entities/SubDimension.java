package com.lti.audit.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sub_dimension")
public class SubDimension {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer subDimensionId;
	
	@Column
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dimension_id")
	private Dimension dimension;

	public Integer getSubDimensionId() {
		return subDimensionId;
	}

	public void setSubDimensionId(Integer subDimensionId) {
		this.subDimensionId = subDimensionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	

}
