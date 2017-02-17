package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.TechnicalName;

@Repository("technicalNameDao")
public class TechnicalNameDaoImpl implements TechnicalNameDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTechnicalName(TechnicalName technicalName) {
		sessionFactory.getCurrentSession().saveOrUpdate(technicalName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechnicalName> listTechnicalName() {
		return (List<TechnicalName>) sessionFactory.getCurrentSession().createCriteria(TechnicalName.class).list();
	}

	@Override
	public TechnicalName getTechnicalName(int technical_id) {
		return (TechnicalName) sessionFactory.getCurrentSession().get(TechnicalName.class, technical_id);
	}

	@Override
	public void delteTechnical(int technical_id) {
		sessionFactory.getCurrentSession().createQuery("DELETE from TechnicalName where technical_id="+technical_id).executeUpdate();
	}

}
