package com.example.administrator.appctct.Entity;

public class Section {
    private String name;
    private Boolean isExpanding;


    public Section(String name, Boolean isExpanding) {
        this.name = name;
        this.isExpanding = isExpanding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExpanding() {
        return isExpanding;
    }

    public void setExpanding(Boolean expanding) {
        isExpanding = expanding;
    }
}
