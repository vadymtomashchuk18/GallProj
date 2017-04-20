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

import com.tomashchuk.GallProj.entities.Biography;


@Repository("biographyDao")
public class BiographyDAOImpl implements BiographyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Biography> getAllBiographies() {
		String sql = "SELECT * FROM Biorgraphy ORDER BY birthCountry";

		List<Biography> biorgraphy = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Biography.class));

		if (biorgraphy.isEmpty()) {
			return null;
		} else {
			return biorgraphy;
		}
	}

	@Override
	public Biography getBiographyId(int id) {
		String sql = "SELECT * FROM Biorgraphy WHERE biorgraphyId=?";
		List<Biography> biorgraphy = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper(Biography.class));
		if (biorgraphy.isEmpty()) {
			return null;
		} else {
			return biorgraphy.get(0);
		}
	}

	@Override
	public void addBiography(Biography biography) {
		String query = "INSERT INTO Biography (birthCountry, birthday, dateOfDeath, otherDetails)"
				+ "VALUES(?, ?, ?, ?, ?)";	
		
		KeyHolder keyHolder2 = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, biography.getBirthCountry());
				ps.setDate(2, ((java.sql.Date) biography.getBirthday()));
				ps.setDate(3, ((java.sql.Date) biography.getDateOfDeath()));
				ps.setString(5, biography.getOtherDetails());
				
				return ps;
			}
		}, keyHolder2);
		long newbiographyId = keyHolder2.getKey().longValue();
		biography.setBiographyId((int) newbiographyId);
		System.out.println("New biographyID:" + newbiographyId);
		
		if (out != 0) {
			System.out.println("Biography saved with id=" + newbiographyId);
		} else
			System.out.println("Biography save failed with id=" + newbiographyId);

	}

	@Override
	public void updateBiography(Biography biography) {
		String query = "UPDATE Exhibition SET birthCountry=?, birthday=?, dateOfDeath=?, otherDetails=?, WHERE biographyId=?";
		
		Object[] args = new Object[] {biography.getBirthCountry(), biography.getBirthday(), biography.getDateOfDeath(),
				biography.getOtherDetails(), biography.getBiographyId()};
		
		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Biography updated with id=" + biography.getBiographyId());
		} else
			System.out.println("Biography update failed with id=" + biography.getBiographyId());

		
	}

	@Override
	public void deleteBiography(int id) {
		String query = "DELETE FROM Biography WHERE biographyId=?";
		
		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Biography deleted with id=" + id);
		} else
			System.out.println("Biography delete failed with id=" + id);
	
	}

	@Override
	public List<Biography> getBirthCountry(String birthCountry) {
		String sql = "SELECT * FROM Biography WHERE birthCountry REGEXP ?";

		String name = "^" + birthCountry;
		List<Biography> biography = jdbcTemplate.query(sql, new Object[] { name },
				new BeanPropertyRowMapper(Biography.class));
		if (biography.isEmpty()) {
			return null;
		} else {
			return biography;
		}
	}
	
}