package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="route_code")
public class RouteCode {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer route_code_id;
	
	@Column
	private String route_code_name;
	
	public Integer getRoute_code_id() {
		return route_code_id;
	}
	public void setRoute_code_id(Integer route_code_id) {
		this.route_code_id = route_code_id;
	}
	public String getRoute_code_name() {
		return route_code_name;
	}
	public void setRoute_code_name(String route_code_name) {
		this.route_code_name = route_code_name;
	}
	

	
}
