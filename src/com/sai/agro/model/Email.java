package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email")
public class Email {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int email_id;
	@Column
	private String email;
	@Column
	private String email_type;
	@Column
	private Integer account_id;
	
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_type() {
		return email_type;
	}
	public void setEmail_type(String email_type) {
		this.email_type = email_type;
	}
	
	
	
}
