package com.tomashchuk.GallProj.dao;

import java.util.List;

import com.tomashchuk.GallProj.entities.Exhibition;

public interface ExhibitionDAO {
	
	public List<Exhibition> getAllExhb();

	public Exhibition getExhbId(int id);

	public void addExhb(final Exhibition exhb);

	public void updateExhb(Exhibition exhb);

	public void deleteExhb(int id);

	public List<Exhibition> getExhbName(String exhibitionName);
}