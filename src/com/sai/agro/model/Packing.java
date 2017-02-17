package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packing")
public class Packing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="packing_id")
	private Integer packing_id;
	
	@Column
    private String packing_name;
	
	public Integer getPacking_id() {
		return packing_id;
	}
	public void setPacking_id(Integer packing_id) {
		this.packing_id = packing_id;
	}
	public String getPacking_name() {
		return packing_name;
	}
	public void setPacking_name(String packing_name) {
		this.packing_name = packing_name;
	}
    
    
}
