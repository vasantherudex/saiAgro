package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.AccountType;

public interface AccountTypeService {
	public void addAccountType(AccountType accountType);
	public List<AccountType> listAccountTypes();
	public AccountType getAccountType(int account_type_id);
	public void deleteAccountType(int account_type_id);
}
