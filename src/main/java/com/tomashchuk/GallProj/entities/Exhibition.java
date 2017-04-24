package com.tomashchuk.GallProj.entities;

import java.sql.Date;

public class Exhibition {

    private int exhibitionId;
    private String exhibitionName;
    private Date dateOpened;
    private Date dateClosed;
    private double priceOfVisiting;
    private String otherDetails;

    
    
    public Exhibition() {
		
	}

	public Exhibition(int exhibitionId, String exibitionName, Date dateOpened, Date dateClosed, String otherDetails) {
        this.exhibitionId = exhibitionId;
        this.exhibitionName = exibitionName;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
        this.otherDetails = otherDetails;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exibitionName) {
        this.exhibitionName = exibitionName;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public double getPriceOfVisiting() {
        return priceOfVisiting;
    }

    public void setPriceOfVisiting(double priceOfVisiting) {
        this.priceOfVisiting = priceOfVisiting;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Exhibition{" +
                "exhibitionId=" + exhibitionId +
                ", exibitionName='" + exhibitionName + '\'' +
                ", dateOpened=" + dateOpened +
                ", dateClosed=" + dateClosed +
                ", priceOfVisiting=" + priceOfVisiting +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
