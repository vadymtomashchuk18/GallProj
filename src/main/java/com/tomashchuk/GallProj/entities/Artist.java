
package com.tomashchuk.GallProj.entities;

import java.util.Date;

public class Artist {

	private int artistId;
    private String lastName;
    private String firstName;
    private String birthCountry;
    private Date birthday;
    private Date dateOfDeath;
    private String otherDetails;
    
	public Artist(int artistId, String lastName, String firstName, String birthCountry, Date birthday, Date dateOfDeath,
			String otherDetails) {
		super();
		this.artistId = artistId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthCountry = birthCountry;
		this.birthday = birthday;
		this.dateOfDeath = dateOfDeath;
		this.otherDetails = otherDetails;
	}
	
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getBirthCountry() {
		return birthCountry;
	}
	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getDateOfDeath() {
		return dateOfDeath;
	}
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", birthCountry=" + birthCountry + ", birthday=" + birthday + ", dateOfDeath=" + dateOfDeath
				+ ", otherDetails=" + otherDetails + "]";
	}
    
	
    
}
