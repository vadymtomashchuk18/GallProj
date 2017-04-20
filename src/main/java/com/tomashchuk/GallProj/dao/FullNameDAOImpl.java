package com.tomashchuk.GallProj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tomashchuk.GallProj.entities.FullName;

@Repository("fullNameDao")
public class FullNameDAOImpl implements FullNameDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<FullName> getAllFullNames() {
		String sql = "SELECT * FROM FullName ORDER BY lastName";

		List<FullName> fllnm = jdbcTemplate.query(sql, new BeanPropertyRowMapper(FullName.class));

		if (fllnm.isEmpty()) {
			return null;
		} else {
			return fllnm;
		}
	}

	@Override
	public FullName getFullNameId(int id) {
		String sql = "SELECT * FROM FullName WHERE fullNameId=?";
		List<FullName> fllnm = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper(FullName.class));
		if (fllnm.isEmpty()) {
			return null;
		} else {
			return fllnm.get(0);
		}
	}

	@Override
	public void addFullName(FullName fllnm) {
		String query = "INSERT INTO FullName () VALUES (?, ?, ?)";
		
		Object[] args = new Object[] {fllnm.getFullNameId(), fllnm.getFirstName(), fllnm.getLastName()};
		
		int out = jdbcTemplate.update(query, args);
		
		if (out != 0) {
			System.out.println("FullName saved with id=" + fllnm.getFullNameId());
		} else
			System.out.println("FullName save failed with id=" + fllnm.getFullNameId());

		
	}

	@Override
	public void updateFullName(FullName fllnm) {
		String query = "UPDATE FullName SET firstName=?, lastName=? WHERE fullNameId=?";
		
		Object[] args = new Object[] {fllnm.getFirstName(), fllnm.getLastName(), fllnm.getFullNameId()};
		
		int out = jdbcTemplate.update(query, args);
		
		if (out != 0) {
			System.out.println("FullName updated with id=" + fllnm.getFullNameId());
		} else
			System.out.println("FullName update failed with id=" + fllnm.getFullNameId());

	}	

	@Override
	public void deleteFullName(int id) {
		String query = "DELETE FROM FullName WHERE fullNameId=?";

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("FullName deleted with num=" + id);
		} else
			System.out.println("No FullName found with num=" + id);
		
	}

	@Override
	public List<FullName> getLastName(String lastName) {
		String sql = "SELECT * FROM FullName WHERE lastName REGEXP ?";
		String lname = "^" + lastName;
		List<FullName> fllnms = jdbcTemplate.query(sql, new Object[] { lname },
				new BeanPropertyRowMapper(FullName.class));
		if (fllnms.isEmpty()) {
			return null;
		} else {
			return fllnms;
		}
	}
	
}