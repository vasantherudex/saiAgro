package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.TechnicalNameDao;
import com.sai.agro.model.TechnicalName;

@Service("technicalNameService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class TechnicalNameServiceImpl implements TechnicalNameService {

	@Autowired
	private TechnicalNameDao technicalNameDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)	
	public void addTechnicalName(TechnicalName technicalName) {
		technicalNameDao.addTechnicalName(technicalName);
	}

	@Override
	public List<TechnicalName> listTechnicalNames() {
		return technicalNameDao.listTechnicalName();
	}

	@Override
	public TechnicalName getTechnicalName(int technical_id) {
		return technicalNameDao.getTechnicalName(technical_id);
	}

	@Override
	public void deleteTechnicalName(int technical_id) {
		technicalNameDao.delteTechnical(technical_id);
	}

}
