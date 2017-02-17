package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.AccountTypeDao;
import com.sai.agro.model.AccountType;
@Service("accountTypeService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired
	private AccountTypeDao accountTypeDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addAccountType(AccountType accountType) {
		accountTypeDao.addAccountType(accountType);
	}

	@Override
	public List<AccountType> listAccountTypes() {
		return accountTypeDao.listAccountTypes();
	}

	@Override
	public AccountType getAccountType(int account_type_id) {
		return accountTypeDao.getAccountType(account_type_id);
	}

	@Override
	public void deleteAccountType(int account_type_id) {
		accountTypeDao.deleteAccountType(account_type_id);
	}

}
