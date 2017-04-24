package com.tomashchuk.GallProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.dao.PaintingDAO;
import com.tomashchuk.GallProj.entities.Painting;

@Service("paintingService")
public class PaintingServiceImpl implements PaintingService {

	@Autowired
	PaintingDAO paintingDao;
	
	@Override
	public List<Painting> getAllPaintings() {
		// TODO Auto-generated method stub
		return paintingDao.getAllPaintings();
	}

	@Override
	public Painting getByPaintingId(int id) {
		// TODO Auto-generated method stub
		return paintingDao.getByPaintingId(id);
	}

	@Override
	public void addPainting(Painting painting) {
		// TODO Auto-generated method stub
		paintingDao.addPainting(painting);
	}

	@Override
	public void deletePainting(int id) {
		// TODO Auto-generated method stub
		paintingDao.deletePainting(id);
	}

	@Override
	public void editPainting(Painting painting) {
		// TODO Auto-generated method stub
		paintingDao.editPainting(painting);
	}

	@Override
	public List<Painting> getByPaintingName(String nameOfPainting) {
		// TODO Auto-generated method stub
		return paintingDao.getByPaintingName(nameOfPainting);
	}

}
