package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catagory")
public class Catagory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer catagory_id;
	@Column
	private String catagory_name;
	
	public Integer getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(Integer catagory_id) {
		this.catagory_id = catagory_id;
	}
	public String getCatagory_name() {
		return catagory_name;
	}
	public void setCatagory_name(String catagory_name) {
		this.catagory_name = catagory_name;
	}
}
