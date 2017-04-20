package com.tomashchuk.GallProj.dao;

import java.util.List;

import com.tomashchuk.GallProj.entities.Biography;

public interface BiographyDAO {
	
	public List<Biography> getAllBiographies();

	public Biography getBiographyId(int id);

	public void addBiography(final Biography biography);

	public void updateBiography(Biography biography);

	public void deleteBiography(int id);

	public List<Biography> getBirthCountry(String birthCountry);
}