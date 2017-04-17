package com.tomashchuk.GallProj.entities;

public class Artist_Movement {

    private int movementCode;
    private int artistId;

    public Artist_Movement(int movementCode, int artistId) {
        this.movementCode = movementCode;
        this.artistId = artistId;
    }

    public int getMovementCode() {
        return movementCode;
    }

    public void setMovementCode(int movementCode) {
        this.movementCode = movementCode;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Artist_Movement{" +
                "movementCode=" + movementCode +
                ", artistId=" + artistId +
                '}';
    }
}
