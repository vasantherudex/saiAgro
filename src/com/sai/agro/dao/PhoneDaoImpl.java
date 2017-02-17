package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.Phone;

@Repository("phoneDao")
public class PhoneDaoImpl implements PhoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPhone(Phone phone) {
		sessionFactory.getCurrentSession().saveOrUpdate(phone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> listPhones() {
		return (List<Phone>) sessionFactory.getCurrentSession().createCriteria(Phone.class).list();
	}

	@Override
	public Phone getPhone(int phone_id) {
		return (Phone) sessionFactory.getCurrentSession().get(Phone.class, phone_id);
	}

	@Override
	public void deletePhone(int phone_id) {
		sessionFactory.getCurrentSession().createQuery("delete from Phone where phone_id = "+phone_id).executeUpdate();
	}

}
