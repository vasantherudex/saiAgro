package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.Email;

@Repository("emailDao")
public class EmailDaoImpl implements EmailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override

	public void addEmail(Email email) {
		sessionFactory.getCurrentSession().saveOrUpdate(email);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> listEmail() {
		return (List<Email>) sessionFactory.getCurrentSession().createCriteria(Email.class).list();
	}

	@Override
	public Email getEmail(int email_id) {
		return (Email) sessionFactory.getCurrentSession().get(Email.class, email_id);
	}

	@Override
	public void deleteEmail(int email_id) {
		sessionFactory.getCurrentSession().createQuery("delete from Email where email_id = "+email_id).executeUpdate();
	}

}
