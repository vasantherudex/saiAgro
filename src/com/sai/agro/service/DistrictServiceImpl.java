package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.DistrictDao;
import com.sai.agro.model.District;

@Service("districtService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictDao districtDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addDistrict(District district) {
		districtDao.addDistrict(district);
	}

	@Override
	public List<District> listDistricts() {
		return districtDao.listDistricts();
	}

	@Override
	public District getDistrict(int district_id) {
		return districtDao.getDistrict(district_id);
	}

	@Override
	public void deleteDistrict(int district_id) {
		districtDao.deleteDistrict(district_id);;
	}

	@Override
	public List<District> listDistricts(int state_id) {
		return districtDao.listDistricts(state_id);
	}

}
