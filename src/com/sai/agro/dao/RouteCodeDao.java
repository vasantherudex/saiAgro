package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.RouteCode;

public interface RouteCodeDao {
	public void addRouteCode(RouteCode routeCode);
	public List<RouteCode> listRouteCodes();
	public RouteCode getRouteCode(int route_code_id);
	public void deleteRouteCode(int route_code_id);
}
