package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.RouteCode;

public interface RouteCodeService {
	public void addRouteCode(RouteCode routeCode);
	public List<RouteCode> listRouteCodes();
	public RouteCode getRouteCode(int route_code_id);
	public void deleteRouteCode(int route_code_id);
}
