package com.tomashchuk.GallProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.dao.FullNameDAO;
import com.tomashchuk.GallProj.entities.FullName;

//@Service("fullNameService")
public class FullNameServiceImpl implements FullNameService{

	@Autowired
	FullNameDAO fullNameDao;
	
	@Override
	public List<FullName> getAllFullNames() {
		// TODO Auto-generated method stub
		return fullNameDao.getAllFullNames();
	}

	@Override
	public FullName getFullNameId(int id) {
		// TODO Auto-generated method stub
		return fullNameDao.getFullNameId(id);
	}

	@Override
	public void addFullName(FullName fllnm) {
		// TODO Auto-generated method stub
		fullNameDao.addFullName(fllnm);
	}

	@Override
	public void updateFullName(FullName fllnm) {
		// TODO Auto-generated method stub
		fullNameDao.updateFullName(fllnm);
	}

	@Override
	public void deleteFullName(int id) {
		// TODO Auto-generated method stub
		fullNameDao.deleteFullName(id);
	}

	@Override
	public List<FullName> getLastName(String lastName) {
		// TODO Auto-generated method stub
		return fullNameDao.getLastName(lastName);
	}

}
