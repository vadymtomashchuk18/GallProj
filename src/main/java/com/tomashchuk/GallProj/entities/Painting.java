package com.tomashchuk.GallProj.entities;

public class Painting {

    private int paintingId;
    private int artistId;
    private int styleId;
    private String nameOfPainting;
    private double priceOfPicture;
    private double widthSize;
    private double heightSize;
    private String otherDetails;

    public Painting(int paintingId, int artistId, int styleId, String nameOfPainting, double priceOfPicture, double widthSize, double heightSize, String otherDetails) {
        this.paintingId = paintingId;
        this.artistId = artistId;
        this.styleId = styleId;
        this.nameOfPainting = nameOfPainting;
        this.priceOfPicture = priceOfPicture;
        this.widthSize = widthSize;
        this.heightSize = heightSize;
        this.otherDetails = otherDetails;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getNameOfPainting() {
        return nameOfPainting;
    }

    public void setNameOfPainting(String nameOfPainting) {
        this.nameOfPainting = nameOfPainting;
    }

    public double getPriceOfPicture() {
        return priceOfPicture;
    }

    public void setPriceOfPicture(double priceOfPicture) {
        this.priceOfPicture = priceOfPicture;
    }

    public double getWidthSize() {
        return widthSize;
    }

    public void setWidthSize(double widthSize) {
        this.widthSize = widthSize;
    }

    public double getHeightSize() {
        return heightSize;
    }

    public void setHeightSize(double heightSize) {
        this.heightSize = heightSize;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Painting{" +
                "paintingId=" + paintingId +
                ", artistId=" + artistId +
                ", styleId=" + styleId +
                ", nameOfPainting='" + nameOfPainting + '\'' +
                ", priceOfPicture=" + priceOfPicture +
                ", widthSize=" + widthSize +
                ", heightSize=" + heightSize +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
