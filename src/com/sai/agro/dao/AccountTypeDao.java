package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.AccountType;

public interface AccountTypeDao {
	public void addAccountType(AccountType accountType);
	public List<AccountType> listAccountTypes();
	public AccountType getAccountType(int account_type_id);
	public void deleteAccountType(int account_type_id);
}
