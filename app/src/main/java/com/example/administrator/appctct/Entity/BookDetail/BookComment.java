package com.example.administrator.appctct.Entity.BookDetail;

public class BookComment {
    private String imgPerson;
    private String namePerson;
    private Float ratio;
    private String comment;


    public BookComment(String imgPerson,String namePerson, Float ratio, String comment) {
        this.imgPerson = imgPerson;
        this.namePerson = namePerson;
        this.ratio = ratio;
        this.comment = comment;
    }

    public String getImgPerson() {
        return imgPerson;
    }

    public Float getRatio() {
        return ratio;
    }

    public String getComment() {
        return comment;
    }

    public String getNamePerson() {
        return namePerson;
    }
}
