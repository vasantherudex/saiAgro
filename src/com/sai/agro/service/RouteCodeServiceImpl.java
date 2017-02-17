package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.RouteCodeDao;
import com.sai.agro.model.RouteCode;

@Service("routeCodeService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class RouteCodeServiceImpl implements RouteCodeService {
	
	@Autowired
	private RouteCodeDao routeCodeDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addRouteCode(RouteCode routeCode) {
		routeCodeDao.addRouteCode(routeCode);
	}

	@Override
	public List<RouteCode> listRouteCodes() {
		return routeCodeDao.listRouteCodes();
	}

	@Override
	public RouteCode getRouteCode(int route_code_id) {
		return routeCodeDao.getRouteCode(route_code_id);
	}

	@Override
	public void deleteRouteCode(int route_code_id) {
		routeCodeDao.deleteRouteCode(route_code_id);
	}

}
