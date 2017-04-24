package com.tomashchuk.GallProj.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tomashchuk.GallProj.entities.Painting;
import com.tomashchuk.GallProj.entities.Style;
import com.tomashchuk.GallProj.entities.Artist;


@Repository("paintingDao")
public class PaintingDAOImpl implements PaintingDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ArtistDAO artistDao;
	
	@Autowired
	private StyleDAO styleDao;
		
	@Override
	public List<Painting> getAllPaintings() {
		String sql = "SELECT * FROM `Painting` ORDER BY nameOfPainting";

		List<Painting> paintings = new ArrayList<Painting>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {

			Painting painting = new Painting();
			painting.setPaintingId((int) row.get("paintingId"));
			//Style style = styleDao.getByStyleId((int) row.get("nameOfStyle"));
			Artist artist = artistDao.getArtistId((int) row.get("artistId"));
			painting.setArtist(artist);
			Style style = styleDao.getByStyleId((int) row.get("styleId"));
			painting.setStyle(style);
			painting.setNameOfPainting((String) row.get("nameOfPainting"));
//			painting.setPriceOfPicture(Double.valueOf((String) row.get("priceOfPicture")));

//			painting.setPriceOfPicture((BigDecimal) row.get("priceOfPicture"));
			painting.setWidthSize((double) row.get("widthSize"));
			painting.setHeightSize((double) row.get("heightSize"));
			painting.setOtherDetails((String) row.get("otherDetails"));
			
			System.out.println(painting);
			
			paintings.add(painting);
		}

		if (paintings.isEmpty()) {
			return null;
		} else {
			return paintings;
		}
	}

	@Override
	public Painting getByPaintingId(int id) {

		String sql = "SELECT * FROM `Painting` WHERE paintingId=?";
		List<Painting> painting = jdbcTemplate.query(sql, new Object[] { id }, new RowMapper<Painting>() {

			public Painting mapRow(ResultSet rs, int rowNum) throws SQLException {
				Painting painting = new Painting();
				painting.setPaintingId(rs.getInt("paintingId"));
				Style style = styleDao.getByStyleId(rs.getInt("styleId"));
				painting.setStyle(style);
				Artist artist = artistDao.getArtistId(rs.getInt("artistId"));
				painting.setArtist(artist);
				painting.setNameOfPainting(rs.getString("nameOfPainting"));
				painting.setPriceOfPicture(rs.getDouble("priceOfPicture"));
				painting.setWidthSize(rs.getDouble("widthSize"));
				painting.setHeightSize(rs.getDouble("heightSize"));
				painting.setOtherDetails(rs.getString("otherDetails"));

				return painting;
			}
		});

		if (painting.isEmpty()) {
			return null;
		} else {
			return painting.get(0);
		}		
	}

	@Override
	public void addPainting(Painting painting) {
		final String query = "INSERT INTO Painting (artistId, styleId, nameOfPainting, priceOfPicture, "
				+ "widthSize, heightSize, otherDetails) VALUES(?, ?, ?, ?, ?, ?, ?);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, painting.getArtist().getArtistId());
				ps.setLong(2, painting.getStyle().getStyleId());
				ps.setString(3, painting.getNameOfPainting());
				ps.setDouble(4, painting.getPriceOfPicture());
				ps.setDouble(5, painting.getWidthSize());
				ps.setDouble(6, painting.getHeightSize());
				ps.setString(7, painting.getOtherDetails());
				
				return ps;
			}
		}, keyHolder);

		long newPersonId = keyHolder.getKey().longValue();
		painting.setPaintingId((int) newPersonId);
		System.out.println("New paintingID:" + newPersonId);

		if (out != 0) {
			System.out.println("Painting saved with id=" + newPersonId);
		} else
			System.out.println("Painting save failed with id=" + newPersonId);
		
	}

	@Override
	public void deletePainting(int id) {
		// TODO Auto-generated method stub

		String query = "DELETE FROM `Painting` WHERE paintingId=?";

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Painting deleted with id=" + id);
		} else
			System.out.println("No painting found with id=" + id);

	}

	@Override
	public void editPainting(Painting painting) {
		String query = "UPDATE Painting SET artistId=?, styleId=?, nameOfPainting=?, priceOfPicture=?, "
				+ "widthSize=?, heightSize=?, otherDetails=? WHERE paintingId=?";

		Object[] args = new Object[] { painting.getArtist().getArtistId(), painting.getStyle().getStyleId(),
				painting.getNameOfPainting(), painting.getPriceOfPicture(), painting.getWidthSize(),
				painting.getHeightSize(), painting.getOtherDetails(), painting.getPaintingId()
				};

		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Painting updated with id=" + painting.getPaintingId());
		} else
			System.out.println("No Painting found with id=" + painting.getPaintingId());
	}

	@Override
	public List<Painting> getByPaintingName(String nameOfPainting) {
		String sql = "SELECT * FROM Painting WHERE nameOfPainting REGEXP ?";
		String lname = "^" + nameOfPainting;
		List<Painting> painting = jdbcTemplate.query(sql, new Object[] { lname },
				new BeanPropertyRowMapper(Painting.class));
		if (painting.isEmpty()) {
			return null;
		} else {
			return painting;
		}
	}

}
