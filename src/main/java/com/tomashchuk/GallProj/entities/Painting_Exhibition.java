package com.tomashchuk.GallProj.entities;

public class Painting_Exhibition {

    private int exhibitionId;
    private int paintingId;

    public Painting_Exhibition(int exhibitionId, int paintingId) {
        this.exhibitionId = exhibitionId;
        this.paintingId = paintingId;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Painting_Exhibition{" +
                "exhibitionId=" + exhibitionId +
                ", paintingId=" + paintingId +
                '}';
    }
}
