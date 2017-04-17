package com.tomashchuk.GallProj.entities;

public class FullName {

    private  int fullNameId;
    private String firstName;
    private String lastName;

    public FullName(int fullNameId, String firstName, String lastName) {
        this.fullNameId = fullNameId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getFullNameId() {
        return fullNameId;
    }

    public void setFullNameId(int fullNameId) {
        this.fullNameId = fullNameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "fullNameId=" + fullNameId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}