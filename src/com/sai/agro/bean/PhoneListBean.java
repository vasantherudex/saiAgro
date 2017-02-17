package com.sai.agro.bean;

import java.util.ArrayList;
import java.util.List;

public class PhoneListBean {
	
	private String phone_no;
	private String phone_type;
	
	
	private List<PhoneListBean> phoneBeanList=new ArrayList<PhoneListBean>();


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}


	public String getPhone_type() {
		return phone_type;
	}


	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}


	public List<PhoneListBean> getPhoneBeanList() {
		return phoneBeanList;
	}


	public void setPhoneBeanList(List<PhoneListBean> phoneBeanList) {
		this.phoneBeanList = phoneBeanList;
	}

}
