package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.Accounts;

public interface AccountsDao {
	public void addAccount(Accounts account);
	public List<Accounts> listAccounts();
	public List<Accounts> listAccounts(String account_code);
	public Accounts getAccount(int account_id);
	public void deleteAccount(int account_id);
}
