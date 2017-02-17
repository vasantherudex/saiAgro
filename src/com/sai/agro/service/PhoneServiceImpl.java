package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.PhoneDao;
import com.sai.agro.model.Phone;

@Service("phoneService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDao phoneDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addPhone(Phone phone) {
		phoneDao.addPhone(phone);
	}

	@Override
	public List<Phone> listPhones() {
		return phoneDao.listPhones();
	}

	@Override
	public Phone getPhone(int phone_id) {
		return phoneDao.getPhone(phone_id);
	}

	@Override
	public void deletePhone(int phone_id) {
		phoneDao.deletePhone(phone_id);
	}

}
