package com.tomashchuk.GallProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.dao.ArtistDAO;
import com.tomashchuk.GallProj.entities.Artist;
import com.tomashchuk.GallProj.entities.Artist_Movement;

@Service("artistService")

public class ArtistServiceImpl implements ArtistService {

	@Autowired
	ArtistDAO artistDao;
	
	@Override
	public List<Artist> getAllArtists() {
		// TODO Auto-generated method stub
		return artistDao.getAllArtists();
	}

	@Override
	public Artist getArtistId(int id) {
		// TODO Auto-generated method stub
		return artistDao.getArtistId(id);
	}

	@Override
	public void addArtist(Artist artist) {
		// TODO Auto-generated method stub
		artistDao.addArtist(artist);
	}

	@Override
	public void updateArtist(Artist artist) {
		// TODO Auto-generated method stub
		artistDao.updateArtist(artist);
	}

	@Override
	public void deleteArtist(int id) {
		// TODO Auto-generated method stub
		artistDao.deleteArtist(id);
	}

	@Override
	public List<Artist> getLastName(String lastName) {
		// TODO Auto-generated method stub
		return artistDao.getLastName(lastName);
	}

	@Override
	public List<Artist_Movement> getAllStylesForArtists() {
		// TODO Auto-generated method stub
		return artistDao.getAllStylesForArtists();
	}

}
