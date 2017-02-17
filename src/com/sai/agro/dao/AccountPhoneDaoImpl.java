package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.AccountPhone;

@Repository("accountPhoneDao")
public class AccountPhoneDaoImpl implements AccountPhoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAccountPhone(AccountPhone accountPhone) {
		sessionFactory.getCurrentSession().saveOrUpdate(accountPhone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountPhone> listAccountPhones() {
		return (List<AccountPhone>) sessionFactory.getCurrentSession().createCriteria(AccountPhone.class).list();
	}

	@Override
	public AccountPhone getAccountPhone(int account_phone_id) {
		return (AccountPhone) sessionFactory.getCurrentSession().get(AccountPhone.class, account_phone_id);
	}

	@Override
	public void deleteAccount(int account_phone_id) {
		sessionFactory.getCurrentSession().createQuery("delete from AccountPhone where account_id = "+account_phone_id).executeUpdate();
	}

}
