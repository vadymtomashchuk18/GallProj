package com.tomashchuk.GallProj.service;

import java.util.List;

import com.tomashchuk.GallProj.entities.Artist;
import com.tomashchuk.GallProj.entities.Artist_Movement;

public interface ArtistService {

	public List<Artist> getAllArtists();
	
	public Artist getArtistId(int id);
	
	public void addArtist(Artist artist);
	
	public void updateArtist(Artist artist);
	
	public void deleteArtist(int id);
	
	public List<Artist> getLastName(String lastName);
	
	public List<Artist_Movement> getAllStylesForArtists();

	public void saveUpdateArtist(Artist artist);
	
	public List<Artist_Movement> getDirectsForArtist();
}
