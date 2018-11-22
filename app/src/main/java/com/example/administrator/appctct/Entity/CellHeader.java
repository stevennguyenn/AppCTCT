package com.example.administrator.appctct.Entity;

public class CellHeader {
    private String img;
    private String name;
    private String points;


    public CellHeader(String img, String name, String points) {
        this.img = img;
        this.name = name;
        this.points = points;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
