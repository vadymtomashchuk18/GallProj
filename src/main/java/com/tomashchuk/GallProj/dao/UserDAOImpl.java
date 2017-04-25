package com.tomashchuk.GallProj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		String sql = "SELECT * FROM User WHERE userId=?";
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
	
	@Override
	public List<User> getUsersByLogin(String login) {
		String sql = "SELECT * FROM User WHERE login=? ";
		List<User> usrs = jdbcTemplate.query(sql, new Object[] { login },
				new BeanPropertyRowMapper(User.class));
		if (usrs.isEmpty()) {
			return null;
		} else {
			return usrs;
		}
	}

	@Override
	public void addUser(User user) {
		final String query = "INSERT INTO User(lastName, firstName, role, login, password)"
				+ " VALUES(?, ?, ?, ?, ?);";

		KeyHolder keyHolder2 = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getLastName());
				ps.setString(2, user.getFirstName());
				ps.setString(3, user.getRole().toString());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getLogin());

				return ps;
			}
		}, keyHolder2);

		long newPersonId = keyHolder2.getKey().longValue();
		user.setUserId((int) (newPersonId));
		System.out.println("New userId:" + newPersonId);

		if (out != 0) {
			System.out.println("User saved with id=" + newPersonId);
		} else
			System.out.println("User save failed with id=" + newPersonId);

	}

	@Override
	public void updateUser(User user) {
		String query = "UPDATE User SET lastName=?, firstName=?, role=?, login=?, password=? WHERE userId=?";

		Object[] args = new Object[] { user.getLastName(), user.getFirstName(), user.getRole(),
				user.getLogin(), user.getPassword(), user.getUserId()};

		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("User updated with id=" + user.getUserId());
		} else
			System.out.println("No user found with id=" + user.getUserId());

	}

	@Override
	public void deleteUser(int id) {

		String query = "DELETE FROM User WHERE userId=?";

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("User deleted with id=" + id);
		} else
			System.out.println("No User found with id=" + id);
		
	}


}