package com.tomashchuk.GallProj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tomashchuk.GallProj.entities.Artist;
import com.tomashchuk.GallProj.entities.Artist_Movement;
import com.tomashchuk.GallProj.entities.Movement;

@Repository("artistDao")
public class ArtistDAOImpl implements ArtistDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Artist> getAllArtists() {
		String sql = "SELECT * FROM Artist ORDER BY lastName";

		List<Artist> artist = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Artist.class));

		if (artist.isEmpty()) {
			return null;
		} else {
			return artist;
		}
	}

	@Override
	public Artist getArtistId(int id) {
		String sql = "SELECT * FROM Artist WHERE artistId=?";
		List<Artist> artist = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper(Artist.class));
		if (artist.isEmpty()) {
			return null;
		} else {
			return artist.get(0);
		}
	}

	@Override
	public void addArtist(Artist artist) {
		String query = "INSERT INTO Artist (lastName, firstName, birthCountry, birthday, dateOfDeath, otherDetails)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";	
		
		KeyHolder keyHolder2 = new GeneratedKeyHolder();
		int out = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, artist.getLastName());
				ps.setString(1, artist.getFirstName());
				ps.setString(1, artist.getBirthCountry());
				ps.setDate(2, ((java.sql.Date) artist.getBirthday()));
				ps.setDate(3, ((java.sql.Date) artist.getDateOfDeath()));
				ps.setString(4, artist.getOtherDetails());
				
				return ps;
			}
		}, keyHolder2);
		long newartistId = keyHolder2.getKey().longValue();
		artist.setArtistId((int) newartistId);
		System.out.println("New artistID:" + newartistId);
		
		if (out != 0) {
			System.out.println("Artist saved with id=" + newartistId);
		} else
			System.out.println("Artist save failed with id=" + newartistId);
	}

	@Override
	public void updateArtist(Artist artist) {
		String query = "UPDATE Artist SET lastName=?, firstName=?, birthCountry=?, birthday=?, dateOfDeath=?, otherDetails=? WHERE artistId=?";
		
		Object[] args = new Object[] {artist.getLastName(), artist.getFirstName(), artist.getBirthCountry(), artist.getBirthday(),
				artist.getDateOfDeath(), artist.getOtherDetails(), artist.getArtistId()};
		
		int out = jdbcTemplate.update(query, args);
		
		if (out != 0) {
			System.out.println("Artist updated with id=" + artist.getArtistId());
		} else
			System.out.println("Artist update failed with id=" + artist.getArtistId());
	}

	@Override
	public void deleteArtist(int id) {
		String query = "DELETE FROM Artist WHERE artistId=?";

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Artist deleted with num=" + id);
		} else
			System.out.println("No Artist found with num=" + id);
	}

	@Override
	public List<Artist> getLastName(String lastName) {
		String sql = "SELECT * FROM Artist WHERE lastName REGEXP ?";
		String lname = "^" + lastName;
		List<Artist> artist = jdbcTemplate.query(sql, new Object[] { lname },
				new BeanPropertyRowMapper(Artist.class));
		if (artist.isEmpty()) {
			return null;
		} else {
			return artist;
		}
	}

	@Override
	public List<Artist_Movement> getAllStylesForArtists() {
		String sql = "SELECT artist.lastName, artist.firstName, movement.nameOfMovement "
				+ "FROM artist_movement INNER JOIN artist ON artist_movement.artistId=artist.artistID "
				+ "INNER JOIN movement ON artist_movement.movementCode=movement.movementCode;";
		
	 return jdbcTemplate.query(sql, mapper);
	}
	
	private RowMapper<Artist_Movement> mapper = new RowMapper<Artist_Movement>(){

		@Override
		public Artist_Movement mapRow(ResultSet arg0, int arg1) throws SQLException {
			Artist artist = new Artist();
			Movement movement = new Movement();
			artist.setFirstName(arg0.getString("firstName"));
			artist.setLastName(arg0.getString("lastName"));
			movement.setNameOfMovement(arg0.getString("nameOfMovement"));
			return new Artist_Movement(artist, movement);
		}
		
	};
}