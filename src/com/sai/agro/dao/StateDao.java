package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.State;

public interface StateDao {
	public void addState(State state);
	public List<State> listStates();
	public State getState(int state_id);
	public void deleteState(int state_id);
}
