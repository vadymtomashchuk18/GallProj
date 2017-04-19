package com.tomashchuk.GallProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomashchuk.GallProj.dao.MovementDAO;
import com.tomashchuk.GallProj.entities.Movement;

@Service("movementService")
public class MovementServiceImpl implements MovementService{

	@Autowired
	MovementDAO movmDao;
	
	@Override
	public List<Movement> getAllMovements() {
		// TODO Auto-generated method stub
		return movmDao.getAllMovements();
	}

	@Override
	public Movement getMovementId(int id) {
		// TODO Auto-generated method stub
		return movmDao.getMovementId(id);
	}

	@Override
	public void addMovement(Movement mov) {
		// TODO Auto-generated method stub
		movmDao.addMovement(mov);
	}

	@Override
	public void updateMovement(Movement mov) {
		// TODO Auto-generated method stub
		movmDao.updateMovement(mov);
	}

	@Override
	public void deleteMovement(int id) {
		// TODO Auto-generated method stub
		movmDao.deleteMovement(id);
	}

	@Override
	public List<Movement> getMovementName(String nameOfMovement) {
		// TODO Auto-generated method stub
		return movmDao.getMovementName(nameOfMovement);
	}

}
