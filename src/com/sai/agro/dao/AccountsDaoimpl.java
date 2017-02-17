package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.Accounts;

@Repository("accountsDao")
public class AccountsDaoimpl implements AccountsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAccount(Accounts account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> listAccounts() {
		return (List<Accounts>) sessionFactory.getCurrentSession().createCriteria(Accounts.class).list();
	}
	
	@Override
	public Accounts getAccount(int account_id) {
		return (Accounts) sessionFactory.getCurrentSession().get(Accounts.class, account_id);
	}

	@Override
	public void deleteAccount(int account_id) {
		sessionFactory.getCurrentSession().createQuery("delete from Accounts where account_id = "+account_id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> listAccounts(String account_code) {
		return (List<Accounts>) sessionFactory.getCurrentSession().createCriteria(Accounts.class).add(Restrictions.ilike("account_code", account_code,MatchMode.ANYWHERE)).list();
	}

}
