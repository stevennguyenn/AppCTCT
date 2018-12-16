package com.example.administrator.appctct.Entity.BookDetail;

public class InformationBook {
    private String nameAuthor;
    private String kind;
    private String information;
    private String dateupload;

    public InformationBook(String nameAuthor, String kind, String information, String dateupload) {
        this.nameAuthor = nameAuthor;
        this.kind = kind;
        this.information = information;
        this.dateupload = dateupload;
    }

    public String getDateupload() {
        return dateupload;
    }

    public String getInformation() {
        return information;
    }

    public String getKind() {
        return kind;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }
}
