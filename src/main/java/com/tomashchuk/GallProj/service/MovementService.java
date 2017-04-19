package com.tomashchuk.GallProj.service;

import java.util.List;

import com.tomashchuk.GallProj.entities.Movement;

public interface MovementService {
	
	public List<Movement> getAllMovements();
	
	public Movement getMovementId(int id);
	
	public void addMovement(Movement mov);
	
	public void updateMovement(Movement mov);
	
	public void deleteMovement(int id);
	
	public List<Movement> getMovementName(String nameOfMovement);
}