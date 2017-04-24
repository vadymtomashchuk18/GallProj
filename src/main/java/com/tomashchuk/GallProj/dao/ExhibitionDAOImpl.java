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

import com.tomashchuk.GallProj.entities.Exhibition;


@Repository("exhibitionDao")
public class ExhibitionDAOImpl implements ExhibitionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Exhibition> getAllExhb() {
		String sql = "SELECT * FROM Exhibition ORDER BY exhibitionName";

		List<Exhibition> exhb = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Exhibition.class));

		if (exhb.isEmpty()) {
			return null;
		} else {
			return exhb;
		}
	}

	@Override
	public Exhibition getExhbId(int id) {
		String sql = "SELECT * FROM Exhibition WHERE exhibitionId=?";
		List<Exhibition> exhb = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper(Exhibition.class));
		if (exhb.isEmpty()) {
			return null;
		} else {
			return exhb.get(0);
		}
	}

	@Override
	public void addExhb(Exhibition exhb) {
		String query = "INSERT INTO Exhibition(exhibitionName, dateOpened, dateClosed, priceOfVisiting, otherDetails)"
				+ "VALUES(?, ?, ?, ?, ?)";	
		
		KeyHolder keyHolder2 = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, exhb.getExhibitionName());
				ps.setDate(2, ((java.sql.Date) exhb.getDateOpened()));
				ps.setDate(3, ((java.sql.Date) exhb.getDateClosed()));
				ps.setDouble(4, exhb.getPriceOfVisiting());
				ps.setString(5, exhb.getOtherDetails());
				
				return ps;
			}
		}, keyHolder2);
		long newExhbId = keyHolder2.getKey().longValue();
		exhb.setExhibitionId((int) newExhbId);
		System.out.println("New exhbID:" + newExhbId);
		
		if (out != 0) {
			System.out.println("Exhibition saved with id=" + newExhbId);
		} else
			System.out.println("Exhibition save failed with id=" + newExhbId);

	}

	@Override
	public void updateExhb(Exhibition exhb) {
		String query = "UPDATE Exhibition SET exhibitionName=?, dateOpened=?, dateClosed=?, priceOfVisiting=?, otherDetails=?, WHERE exhibitionId=?";
		
		Object[] args = new Object[] {exhb.getExhibitionName(), exhb.getDateOpened(), exhb.getDateClosed(), 
				exhb.getPriceOfVisiting(), exhb.getOtherDetails(), exhb.getExhibitionId()};
		
		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Exhibiiton updated with id=" + exhb.getExhibitionId());
		} else
			System.out.println("Exhibition update failed with id=" + exhb.getExhibitionId());
	}

	@Override
	public void deleteExhb(int id) {
		String query = "DELETE FROM Exhibition WHERE exhibitionId=?";
		
		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Exhibiiton deleted with id=" + id);
		} else
			System.out.println("Exhibition delete failed with id=" + id);
	}
	

	@Override
	public List<Exhibition> getExhbName(String exhibitionName) {
		String sql = "SELECT * FROM Exhibition WHERE exhibitionName REGEXP ?";

		String name = "^" + exhibitionName;
		List<Exhibition> empls = jdbcTemplate.query(sql, new Object[] { name },
				new BeanPropertyRowMapper(Exhibition.class));
		if (empls.isEmpty()) {
			return null;
		} else {
			return empls;
		}
	}
	
}