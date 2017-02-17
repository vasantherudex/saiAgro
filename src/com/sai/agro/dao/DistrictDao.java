package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.District;

public interface DistrictDao {
	public void addDistrict(District district);
	public List<District> listDistricts();
	public List<District> listDistricts(int state_id);
	public District getDistrict(int district_id);
	public void deleteDistrict(int district_id);
}
