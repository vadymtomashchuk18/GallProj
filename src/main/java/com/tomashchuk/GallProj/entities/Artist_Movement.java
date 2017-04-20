package com.tomashchuk.GallProj.entities;

public class Artist_Movement {
	
	private Artist artist;
	private Movement movement;
	
	public Artist_Movement() {
		
	}

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

	@Override
	public String toString() {
		return "Artist_Movement [artist=" + artist + ", movement=" + movement + "]";
	}
	
	
	
}
