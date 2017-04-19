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

import com.tomashchuk.GallProj.entities.Movement;

@Repository("movementDao")
public class MovementDAOImpl implements MovementDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Movement> getAllMovements() {
		String sql = "SELECT * FROM Movement ORDER BY nameOfMovement";

		List<Movement> mov = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Movement.class));

		if (mov.isEmpty()) {
			return null;
		} else {
			return mov;
		}
	}

	@Override
	public Movement getMovementId(int id) {
		String sql = "SELECT * FROM Movement WHERE movementCode=?";
		List<Movement> movm = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper(Movement.class));
		if (movm.isEmpty()) {
			return null;
		} else {
			return movm.get(0);
		}

	}

	@Override
	public void addMovement(Movement mov) {
		String query = "INSERT INTO Movement (nameOfMovement) VALUES(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, mov.getNameOfMovement());

				return ps;
			}
		}, keyHolder);

		long newMovementCode = keyHolder.getKey().longValue();
		mov.setMovementCode((int) (newMovementCode));
		System.out.println("New movement code:" + newMovementCode);

		if (out != 0) {
			System.out.println("Movement saved with id=" + newMovementCode);
		} else
			System.out.println("Movement save failed with id=" + newMovementCode);
		
	}

	@Override
	public void updateMovement(Movement mov) {
		String query = "UPDATE Movement SET nameOfMovement=? WHERE movementCode=?";

		Object[] args = new Object[] { mov.getNameOfMovement(), mov.getMovementCode() };

		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Movement updated with id=" + mov.getMovementCode());
		} else
			System.out.println("No Movement found with id=" + mov.getMovementCode());
		
	}

	@Override
	public void deleteMovement(int id) {
		String query = "DELETE FROM Movement WHERE movementCode=?";

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Movement deleted with num=" + id);
		} else
			System.out.println("No Movement found with num=" + id);
		
	}

	@Override
	public List<Movement> getMovementName(String name) {
		String sql = "SELECT * FROM Movement WHERE nameOfMovement REGEXP ?";
		String name2 = "^" + name;
		List<Movement> movm = jdbcTemplate.query(sql, new Object[] { name2 },
				new BeanPropertyRowMapper(Movement.class));
		if (movm.isEmpty()) {
			return null;
		} else {
			return movm;
		}

	}
	
}

