package com.tomashchuk.GallProj.entities;

public class Movement {

    private int movementCode;
    private String nameOfMovement;
    private String description;

    public Movement(int movementCode, String nameOfMovement) {
        this.movementCode = movementCode;
        this.nameOfMovement = nameOfMovement;
    }

    public Movement(int movementCode, String nameOfMovement, String description) {
        this.movementCode = movementCode;
        this.nameOfMovement = nameOfMovement;
        this.description = description;
    }

    public int getMovementCode() {
        return movementCode;
    }

    public void setMovementCode(int movementCode) {
        this.movementCode = movementCode;
    }

    public String getNameOfMovement() {
        return nameOfMovement;
    }

    public void setNameOfMovement(String nameOfMovement) {
        this.nameOfMovement = nameOfMovement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Movement{" +
                "movementCode=" + movementCode +
                ", nameOfMovement='" + nameOfMovement + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
