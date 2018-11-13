package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelQuestion {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("content_question")
    @Expose
    private String content_question;

    @SerializedName("question_a")
    @Expose
    private String question_a;

    @SerializedName("question_b")
    @Expose
    private String question_b;

    @SerializedName("question_c")
    @Expose
    private String question_c;

    @SerializedName("question_d")
    @Expose
    private String question_d;

    public String getId() {
        return id;
    }
    public String getContent_question() {
        return content_question;
    }

    public String getQuestion_a() {
        return question_a;
    }

    public String getQuestion_b() {
        return question_b;
    }

    public String getQuestion_c() {
        return question_c;
    }

    public String getQuestion_d() {
        return question_d;
    }
}
