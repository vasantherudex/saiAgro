package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_phone")
public class AccountPhone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer account_phone_id;
	@Column
	private Integer account_id;
	@Column
	private Integer phone_id;
	
	public Integer getAccount_phone_id() {
		return account_phone_id;
	}
	public void setAccount_phone_id(Integer account_phone_id) {
		this.account_phone_id = account_phone_id;
	}
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public Integer getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(Integer phone_id) {
		this.phone_id = phone_id;
	}
	
}
