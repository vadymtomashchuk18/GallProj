package com.tomashchuk.GallProj.dao;

import java.sql.Date;
import java.util.List;

import com.tomashchuk.GallProj.entities.Painting;



public interface PaintingDAO {
	public List<Painting> getAllPaintings();

	public Painting getByPaintingId(int id);

	public void addPainting(Painting painting);

	public void deletePainting(int id);
	
	public void editPainting(Painting painting);

	public List<Painting> getByPaintingName(String nameOfPainting);
}
