package com.tomashchuk.GallProj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tomashchuk.GallProj.entities.Exhibition;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExhb(Exhibition exhb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteexhb(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Exhibition> getExhbSurn(String surname) {
		// TODO Auto-generated method stub
		return null;
	}
	
}