package com.tomashchuk.GallProj.entities;

import java.util.Date;

public class Biography {

    private int biographyId;
    private String birthCountry;
    private Date birthday;
    private Date dateOfDeath;
    private String otherDetails;

    public Biography(int biographyId, String birthCountry, Date birthday, Date dateOfDeath, String otherDetails) {
        this.biographyId = biographyId;
        this.birthCountry = birthCountry;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        this.otherDetails = otherDetails;
    }

    public int getBiographyId() {
        return biographyId;
    }

    public void setBiographyId(int biographyId) {
        this.biographyId = biographyId;
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
        return "Biography{" +
                "biographyId=" + biographyId +
                ", birthCountry='" + birthCountry + '\'' +
                ", birthday=" + birthday +
                ", dateOfDeath=" + dateOfDeath +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}