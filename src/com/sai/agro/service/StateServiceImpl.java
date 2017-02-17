package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.StateDao;
import com.sai.agro.model.State;

@Service("stateService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDao stateDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addState(State state) {
		stateDao.addState(state);
	}
	
	@Override
	public List<State> listStates() {
		return stateDao.listStates();
	}

	@Override
	public State getState(int state_id) {
		return stateDao.getState(state_id);
	}

	@Override
	public void deleteState(int state_id) {
		stateDao.deleteState(state_id);
	}

}
