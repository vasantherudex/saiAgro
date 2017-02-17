package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="technical_name")
public class TechnicalName {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer technical_id;
	
	@Column
	private String technical_name;

	public Integer getTechnical_id() {
		return technical_id;
	}

	public void setTechnical_id(Integer technical_id) {
		this.technical_id = technical_id;
	}

	public String getTechnical_name() {
		return technical_name;
	}

	public void setTechnical_name(String technical_name) {
		this.technical_name = technical_name;
	}
}
