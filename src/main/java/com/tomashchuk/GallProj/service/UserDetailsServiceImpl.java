package com.tomashchuk.GallProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.dao.UserDAO;
import com.tomashchuk.GallProj.entities.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDAO usrDao;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User usr = usrDao.getUserLogin(login);

		if (usr == null) {
			throw new UsernameNotFoundException("Username " + login + " doesn't exist");
		}
		return usr;
	}

}
