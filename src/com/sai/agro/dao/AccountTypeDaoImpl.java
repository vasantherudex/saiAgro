package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.AccountType;

@Repository("accountTypeDao")
public class AccountTypeDaoImpl implements AccountTypeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAccountType(AccountType accountType) {
		sessionFactory.getCurrentSession().saveOrUpdate(accountType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountType> listAccountTypes() {
		return (List<AccountType>) sessionFactory.getCurrentSession().createCriteria(AccountType.class).list();
	}

	@Override
	public AccountType getAccountType(int account_type_id) {
		return (AccountType) sessionFactory.getCurrentSession().get(AccountType.class, account_type_id);
	}

	@Override
	public void deleteAccountType(int account_type_id) {
		sessionFactory.getCurrentSession().createQuery("delete from AccountType where account_type_id = "+account_type_id).executeUpdate();
	}

}
