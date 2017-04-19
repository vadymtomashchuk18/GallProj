package com.tomashchuk.GallProj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tomashchuk.GallProj.entities.User;


@Repository("userDao")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM User ORDER BY lastname";

		List<User> usrs = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));

		if (usrs.isEmpty()) {
			return null;
		} else {
			return usrs;
		}
	}

	@Override
	public User getUserId(int id) {
		String sql = "SELECT * FROM User WHERE id_empl=?";
		List<User> usrs = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper(User.class));
		if (usrs.isEmpty()) {
			return null;
		} else {
			return usrs.get(0);
		}
	}

	@Override
	public List<User> getUserRole(String role) {
		String sql = "SELECT * FROM User WHERE role=?";
		List<User> usrs = jdbcTemplate.query(sql, new Object[] { role }, new BeanPropertyRowMapper(User.class));
		if (usrs.isEmpty()) {
			return null;
		} else {
			return usrs;
		}
	}

	@Override
	public User getUserAuth(String login, String password) {
		String sql = "SELECT * FROM User WHERE login=? AND password=?";
		List<User> usrs = jdbcTemplate.query(sql, new Object[] { login, password },
				new BeanPropertyRowMapper(User.class));
		if (usrs.isEmpty()) {
			return null;
		} else {
			return usrs.get(0);
		}
	}

	@Override
	public User getUserLogin(String login) {
		String sql = "SELECT * FROM User WHERE login=? ";
		List<User> usrs = jdbcTemplate.query(sql, new Object[] { login },
				new BeanPropertyRowMapper(User.class));
		if (usrs.isEmpty()) {
			return null;
		} else {
			return usrs.get(0);
		}
	}


}