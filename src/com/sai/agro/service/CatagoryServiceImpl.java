package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.CatagoryDao;
import com.sai.agro.model.Catagory;

@Service("catagoryService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryDao catagoryDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addCatagory(Catagory catagory) {
		catagoryDao.addCatagory(catagory);
	}

	@Override
	public List<Catagory> listCatagory() {
		return catagoryDao.listCatagory();
	}

	@Override
	public Catagory getCatagory(int catagory_id) {
		return catagoryDao.getCatagory(catagory_id);
	}

	@Override
	public void deleteCatagory(int catagory_id) {
		catagoryDao.deleteCatagory(catagory_id);
	}

}
