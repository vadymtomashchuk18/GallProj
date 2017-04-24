package com.tomashchuk.GallProj.entities;

public class Artist_Movement {

	private int artistId;
	private int movementId;
	
	
	public Artist_Movement() {
		
	}


	public Artist_Movement(int artistId, int movementId) {
		
		this.artistId = artistId;
		this.movementId = movementId;
	}


	public int getArtistId() {
		return artistId;
	}


	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}


	public int getMovementId() {
		return movementId;
	}


	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}


	@Override
	public String toString() {
		return "Artist_Movement [artistId=" + artistId + ", movementId=" + movementId + "]";
	}
	
	
	
		
	private Artist artist;
	private Movement movement;
	
	

	public Artist_Movement(Artist artist, Movement movement) {
		
		this.artist = artist;
		this.movement = movement;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	/*
	@Override
	public String toString() {
		return "Artist_Movement [artist=" + artist + ", movement=" + movement + "]";
	}
*/
	
	
}
