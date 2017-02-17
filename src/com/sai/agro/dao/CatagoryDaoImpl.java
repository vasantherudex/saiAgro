package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.Catagory;

@Repository("catagoryDao")
public class CatagoryDaoImpl implements CatagoryDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCatagory(Catagory catagory) {
		sessionFactory.getCurrentSession().saveOrUpdate(catagory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Catagory> listCatagory() {
		return (List<Catagory>) sessionFactory.getCurrentSession().createCriteria(Catagory.class).list();
	}

	@Override
	public Catagory getCatagory(int catagory_id) {
		return (Catagory) sessionFactory.getCurrentSession().get(Catagory.class, catagory_id);
	}

	@Override
	public void deleteCatagory(int catagory_id) {
		sessionFactory.getCurrentSession().createQuery("delete from Catagory where catagory_id="+catagory_id).executeUpdate();
	}

}
