package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.AccountsDao;
import com.sai.agro.model.Accounts;

@Service("accountsService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsDao accountsDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addAccount(Accounts account) {
		accountsDao.addAccount(account);
	}

	@Override
	public List<Accounts> listAccounts() {
		return accountsDao.listAccounts();
	}

	@Override
	public Accounts getAccount(int account_id) {
		return accountsDao.getAccount(account_id);
	}

	@Override
	public void deleteAccount(int account_id) {
		accountsDao.deleteAccount(account_id);
	}

	@Override
	public List<Accounts> listAccounts(String account_code) {
		return accountsDao.listAccounts(account_code);
	}

}
