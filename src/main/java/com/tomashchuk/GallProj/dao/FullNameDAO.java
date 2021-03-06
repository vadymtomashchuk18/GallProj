package com.tomashchuk.GallProj.dao;

import java.util.List;

import com.tomashchuk.GallProj.entities.FullName;

public interface FullNameDAO {
	
	public List<FullName> getAllFullNames();
	
	public FullName getFullNameId(int id);
	
	public void addFullName(FullName fllnm);
	
	public void updateFullName(FullName fllnm);
	
	public void deleteFullName(int id);
	
	public List<FullName> getLastName(String lastName);
	
}