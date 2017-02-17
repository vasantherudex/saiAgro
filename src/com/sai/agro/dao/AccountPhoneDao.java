package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.AccountPhone;

public interface AccountPhoneDao {
	public void addAccountPhone(AccountPhone accountPhone);
	public List<AccountPhone> listAccountPhones();
	public AccountPhone getAccountPhone(int account_phone_id);
	public void deleteAccount(int account_phone_id);
}
