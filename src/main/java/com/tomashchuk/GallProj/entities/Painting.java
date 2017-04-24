package com.tomashchuk.GallProj.entities;



public class Painting {

    private int paintingId;
    private Artist artist;
    private Style style;
    private String nameOfPainting;
    private double priceOfPicture;
    private double widthSize;
    private double heightSize;
    private String otherDetails;

    public Painting() {
	}
    
	public Painting(int paintingId, Artist artist, Style style, String nameOfPainting, double priceOfPicture,
			double widthSize, double heightSize, String otherDetails) {
		super();
		this.paintingId = paintingId;
		this.artist = artist;
		this.style = style;
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

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
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

	@Override
	public String toString() {
		return "Painting [paintingId=" + paintingId + ", artist=" + artist + ", style=" + style + ", nameOfPainting="
				+ nameOfPainting + ", priceOfPicture=" + priceOfPicture + ", widthSize=" + widthSize + ", heightSize="
				+ heightSize + ", otherDetails=" + otherDetails + "]";
	}
    
}
