package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> listUser();
	public User getUser(String user_name);
	public void deleteUser(String user_id);
}
