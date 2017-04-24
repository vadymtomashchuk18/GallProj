package com.tomashchuk.GallProj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tomashchuk.GallProj.entities.Style;

@Repository("styleDao")
public class StyleDAOImpl implements StyleDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Style> getAllStyles() {
		String sql = "SELECT * FROM Style ORDER BY nameOfStyle";

		List<Style> stl = new ArrayList<Style>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Style style= new Style();
			style.setStyleId((int) (row.get("styleId")));
			style.setNameOfStyle((String) row.get("nameOfStyle"));
			style.setStyleDescription((String) row.get("styleDescription"));
			
			stl.add(style);
		}

		if (stl.isEmpty()) {
			return null;
		} else {
			return stl;
		}
	}

	@Override
	public Style getByStyleId(int id) {
		String sql = "SELECT * FROM Style WHERE styleId=?";
		List<Style> stl = jdbcTemplate.query(sql, new Object[] { id }, new RowMapper<Style>() {

			public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
				Style style = new Style();
				style.setStyleId(rs.getInt("styleId"));
				style.setNameOfStyle(rs.getString("nameOfStyle"));
				style.setStyleDescription(rs.getString("styleDescription"));
				return style;
			}
		});

		if (stl.isEmpty()) {
			return null;
		} else {
			return stl.get(0);
		}
	}

	@Override
	public void addStyle(Style style) {
		final String query = "INSERT INTO Style (nameOfStyle, styleDescription) VALUES(?, ?);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, style.getNameOfStyle());
				ps.setString(2, style.getStyleDescription());
				return ps;
			}
		}, keyHolder);

		long newStyleId = keyHolder.getKey().longValue();
		style.setStyleId((int) (newStyleId));
		System.out.println("New styleID:" + newStyleId);

		if (out != 0) {
			System.out.println("Style saved with id=" + newStyleId);
		} else
			System.out.println("Style save failed with id=" + newStyleId);

	}

	@Override
	public void deleteStyle(int id) {
		String query = "DELETE FROM Style WHERE styleId=?";

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Style deleted with id=" + id);
		} else
			System.out.println("No Style found with id=" + id);

		
	}

	@Override
	public void editStyle(Style style) {
		// TODO Auto-generated method stub
		String query = "UPDATE Style SET nameOfStyle=?, styleDescription=? WHERE styleId=?";

		Object[] args = new Object[] { style.getNameOfStyle(), style.getStyleDescription(), style.getStyleId()};

		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Style updated with id=" + style.getStyleId());
		} else
			System.out.println("No Style found with id=" + style.getStyleId());

	}
	private RowMapper<Style> mapper = new RowMapper<Style>(){
		@Override
		public Style mapRow(ResultSet sql, int arg1) throws SQLException {
			Style style = new Style();
			style.setNameOfStyle(sql.getString("nameOfStyle"));
			style.setStyleDescription(sql.getString("styleDescription"));
			return style;
		}
		
	};
}
