package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.Packing;

@Repository("packingDao")
public class PackingDaoImpl implements PackingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPacking(Packing packing) {
		sessionFactory.getCurrentSession().saveOrUpdate(packing);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Packing> listPacking() {
		return (List<Packing>) sessionFactory.getCurrentSession().createCriteria(Packing.class).list();
	}

	@Override
	public Packing getPacking(int packing_id) {
		return (Packing) sessionFactory.getCurrentSession().get(Packing.class, packing_id);
	}

	@Override
	public void deletePacking(int packing_id) {
		sessionFactory.getCurrentSession().createQuery("delete from Packing where packing_id = "+packing_id).executeUpdate();
	}

}
