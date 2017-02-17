package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.District;
@Repository("districtDao")
public class DistrictDaoImpl implements DistrictDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addDistrict(District district) {
		sessionFactory.getCurrentSession().saveOrUpdate(district);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> listDistricts() {
		return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class).list();
	}

	@Override
	public District getDistrict(int district_id) {
		return (District) sessionFactory.getCurrentSession().get(District.class, district_id);
	}

	@Override
	public void deleteDistrict(int district_id) {
		sessionFactory.getCurrentSession().createQuery("delete from District where district_id = "+district_id).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> listDistricts(int state_id) {
		return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class).add(Restrictions.eq("state_id",state_id)).list();
	}

}
