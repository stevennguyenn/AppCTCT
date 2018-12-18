package com.example.administrator.appctct.Entity.BookDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookComment {
    @SerializedName("id_user")
    @Expose
    private String idUser;

    @SerializedName("img_person")
    @Expose
    private String avatar;

    @SerializedName("name_person")
    @Expose
    private String fullName;

    @SerializedName("ratio")
    @Expose
    private Float ratio;

    @SerializedName("comment")
    @Expose
    private String contentComment;

    public BookComment(String imgPerson,String namePerson, Float ratio, String comment) {
        this.avatar = imgPerson;
        this.fullName = namePerson;
        this.ratio = ratio;
        this.contentComment = comment;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getAvatar() {
        return avatar;
    }

    public Float getRatio() {
        return ratio;
    }

    public String getContentComment() {
        return contentComment;
    }

    public String getFullName() {
        return fullName;
    }
}
