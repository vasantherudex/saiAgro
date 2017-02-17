package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int phone_id;
	@Column
	private Long phone_no;
	@Column
	private String phone_type;
	@Column
	private Integer account_id;
	
	public int getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}
	public Long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	public String getPhone_type() {
		return phone_type;
	}
	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	
}
