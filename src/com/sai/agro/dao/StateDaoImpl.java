package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.State;
@Repository("stateDao")
public class StateDaoImpl implements StateDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addState(State state) {
		sessionFactory.getCurrentSession().saveOrUpdate(state);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> listStates() {
		return (List<State>) sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}

	@Override
	public State getState(int state_id) {
		return (State) sessionFactory.getCurrentSession().get(State.class,state_id);
	}

	@Override
	public void deleteState(int state_id) {
		sessionFactory.getCurrentSession().createQuery("delete from State where state_id = "+state_id).executeUpdate();
	}

}
