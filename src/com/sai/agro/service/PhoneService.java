package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.Phone;

public interface PhoneService {
	public void addPhone(Phone phone);
	public List<Phone> listPhones();
	public Phone getPhone(int phone_id);
	public void deletePhone(int phone_id);
}
