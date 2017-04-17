
package com.tomashchuk.GallProj.entities;

public class Artist {

	private int artistId;
	private int fullNameId;
	private int biographyId;


	public Artist(int artistId, int fullNameId, int biographyId) {
		this.artistId = artistId;
		this.fullNameId = fullNameId;
		this.biographyId = biographyId;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public int getFullNameId() {
		return fullNameId;
	}

	public void setFullNameId(int fullNameId) {
		this.fullNameId = fullNameId;
	}

	public int getBiographyId() {
		return biographyId;
	}

	public void setBiographyId(int biographyId) {
		this.biographyId = biographyId;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Artist{" +
				"artistId=" + artistId +
				", fullNameId=" + fullNameId +
				", biographyId=" + biographyId +
				'}';
	}
}
