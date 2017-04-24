package com.tomashchuk.GallProj.service;

import java.util.List;

import com.tomashchuk.GallProj.entities.User;

public interface UserService {
	public List<User> getAllUsers();
	
	public User getUserId(int id);
	
	public List<User> getUserRole(String role);

	public User getUserAuth(String login, String password);

	public User getUserLogin(String login);
}
