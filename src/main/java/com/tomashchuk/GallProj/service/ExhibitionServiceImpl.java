package com.tomashchuk.GallProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.entities.Exhibition;
import com.tomashchuk.GallProj.dao.ExhibitionDAO;

@Service("exhibitionService")
public class ExhibitionServiceImpl implements ExhibitionService{

	@Autowired
	ExhibitionDAO exhbDao;
	
	@Override
	public List<Exhibition> getAllExhb() {
		// TODO Auto-generated method stub
		return exhbDao.getAllExhb();
	}

	@Override
	public Exhibition getExhbId(int id) {
		// TODO Auto-generated method stub
		return exhbDao.getExhbId(id);
	}

	@Override
	public void addExhb(Exhibition exhb) {
		// TODO Auto-generated method stub
		exhbDao.addExhb(exhb);
	}

	@Override
	public void updateExhb(Exhibition exhb) {
		// TODO Auto-generated method stub
		exhbDao.updateExhb(exhb);
	}

	@Override
	public void deleteExhb(int id) {
		// TODO Auto-generated method stub
		exhbDao.deleteExhb(id);
	}

	@Override
	public List<Exhibition> getExhbName(String exhibitionName) {
		// TODO Auto-generated method stub
		return exhbDao.getExhbName(exhibitionName);
	}

	@Override
	public void saveUpdateExhb(Exhibition exhb) {
		// TODO Auto-generated method stub
		if (exhb.getExhibitionId() > 0) {
			// update
			exhbDao.updateExhb(exhb);;
		} else {
			// insert
			exhbDao.addExhb(exhb);;
		}
	}

}
