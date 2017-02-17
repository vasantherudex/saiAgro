package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.State;

public interface StateService {
	public void addState(State state);
	public List<State> listStates();
	public State getState(int state_id);
	public void deleteState(int state_id);
}
