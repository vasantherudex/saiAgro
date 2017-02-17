package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.RouteCode;

@Repository("routeCodeDao")
public class RouteCodeDaoImpl implements RouteCodeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRouteCode(RouteCode routeCode) {
		sessionFactory.getCurrentSession().saveOrUpdate(routeCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RouteCode> listRouteCodes() {
		return (List<RouteCode>) sessionFactory.getCurrentSession().createCriteria(RouteCode.class).list();
	}

	@Override
	public RouteCode getRouteCode(int route_code_id) {
		return (RouteCode) sessionFactory.getCurrentSession().get(RouteCode.class, route_code_id);
	}

	@Override
	public void deleteRouteCode(int route_code_id) {
		sessionFactory.getCurrentSession().createQuery("delete from RouteCode where route_code_id = "+route_code_id).executeUpdate();
	}

}
