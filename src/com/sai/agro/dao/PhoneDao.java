package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.Phone;

public interface PhoneDao {
	public void addPhone(Phone phone);
	public List<Phone> listPhones();
	public Phone getPhone(int phone_id);
	public void deletePhone(int phone_id);
}
