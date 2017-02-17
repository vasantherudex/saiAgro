package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.AccountPhoneDao;
import com.sai.agro.model.AccountPhone;

@Service("accountPhoneService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class AccountPhoneServiceImpl implements AccountPhoneService {
	@Autowired
	private AccountPhoneDao accountPhoneDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addAccountPhone(AccountPhone accountPhone) {
		accountPhoneDao.addAccountPhone(accountPhone);
	}

	@Override
	public List<AccountPhone> listAccountPhones() {
		return accountPhoneDao.listAccountPhones();
	}

	@Override
	public AccountPhone getAccountPhone(int account_phone_id) {
		return accountPhoneDao.getAccountPhone(account_phone_id);
	}

	@Override
	public void deleteAccount(int account_phone_id) {
		accountPhoneDao.deleteAccount(account_phone_id);
	}

}
