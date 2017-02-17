package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {	
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User getUser(String user_name) {
		System.out.println("bean user name: "+user_name);
		User user=(User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("user_name", user_name));
		System.out.println("username: "+user.getUser_name());
		return null; 
	}

	@Override
	public void deleteUser(String user_id) {
		sessionFactory.getCurrentSession().createQuery("delete from User where user_id = "+user_id).executeUpdate();
	}

}
