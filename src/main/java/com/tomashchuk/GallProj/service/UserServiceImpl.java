package com.tomashchuk.GallProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.dao.UserDAO;
import com.tomashchuk.GallProj.entities.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public User getUserId(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserId(id);
	}

	@Override
	public List<User> getUserRole(String role) {
		// TODO Auto-generated method stub
		return userDao.getUserRole(role);
	}

	@Override
	public User getUserAuth(String login, String password) {
		// TODO Auto-generated method stub
		return userDao.getUserAuth(login, password);
	}

	@Override
	public User getUserLogin(String login) {
		// TODO Auto-generated method stub
		return userDao.getUserLogin(login);
	}

}
