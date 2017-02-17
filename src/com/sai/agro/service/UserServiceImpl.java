package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.UserDao;
import com.sai.agro.model.User;

@Service("userService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}

	@Override
	public User getUser(String user_name) {
		return userDao.getUser(user_name);
	}

	@Override
	public void deleteUser(String user_id) {
		userDao.deleteUser(user_id);
	}
	

}
