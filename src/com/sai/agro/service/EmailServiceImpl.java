package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.EmailDao;
import com.sai.agro.model.Email;

@Service("emailService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addEmail(Email email) {
		emailDao.addEmail(email);
	}

	@Override
	public List<Email> listEmail() {
		return emailDao.listEmail();
	}

	@Override
	public Email getEmail(int email_id) {
		return emailDao.getEmail(email_id);
	}

	@Override
	public void deleteEmail(int email_id) {
		emailDao.deleteEmail(email_id);
	}

}
