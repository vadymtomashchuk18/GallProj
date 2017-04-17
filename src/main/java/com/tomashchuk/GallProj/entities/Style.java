package com.tomashchuk.GallProj.entities;

public class Style {

    private int styleId;
    private String nameOfStyle;
    private String styleDescription;

    public Style(int styleId, String nameOfStyle, String styleDescription) {
        this.styleId = styleId;
        this.nameOfStyle = nameOfStyle;
        this.styleDescription = styleDescription;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getNameOfStyle() {
        return nameOfStyle;
    }

    public void setNameOfStyle(String nameOfStyle) {
        this.nameOfStyle = nameOfStyle;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Style{" +
                "styleId=" + styleId +
                ", nameOfStyle='" + nameOfStyle + '\'' +
                ", styleDescription='" + styleDescription + '\'' +
                '}';
    }
}
