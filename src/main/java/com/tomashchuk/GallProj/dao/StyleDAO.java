package com.tomashchuk.GallProj.dao;

import java.util.List;

import com.tomashchuk.GallProj.entities.Style;


public interface StyleDAO {
	
	public List<Style> getAllStyles();

	public Style getByStyleId(int id);

	public void addStyle(Style style);

	public void deleteStyle(int id);
	
	public void editStyle(Style painting);

}
