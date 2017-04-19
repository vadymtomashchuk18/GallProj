package com.tomashchuk.GallProj.dao;

import java.util.List;

import com.tomashchuk.GallProj.entities.User;

public interface UserDAO {

	public List<User> getAllUsers();
	
	public User getUserId(int id);
	
	public List<User> getUserRole(String role);

	public User getUserAuth(String login, String password);

	public User getUserLogin(String login);
}