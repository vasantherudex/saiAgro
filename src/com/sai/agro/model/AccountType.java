package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_type")
public class AccountType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer account_type_id;
	@Column
	private String account_type_name;
	
	
	public Integer getAccount_type_id() {
		return account_type_id;
	}
	public void setAccount_type_id(Integer account_type_id) {
		this.account_type_id = account_type_id;
	}
	public String getAccount_type_name() {
		return account_type_name;
	}
	public void setAccount_type_name(String account_type_name) {
		this.account_type_name = account_type_name;
	}
	
	
}
