package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionTestTested {
    @SerializedName("content_question")
    @Expose
    private String contentQuestion;

    @SerializedName("question_a")
    @Expose
    private String questionA;

    @SerializedName("question_b")
    @Expose
    private String questionB;

    @SerializedName("question_c")
    @Expose
    private String questionC;

    @SerializedName("question_d")
    @Expose
    private String questionD;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("image_result")
    @Expose
    private String imageResult;

    @SerializedName("value_user_choice")
    @Expose
    private String valueUserChocie;

    public String getQuestionD() {
        return questionD;
    }

    public String getQuestionC() {
        return questionC;
    }

    public String getQuestionB() {
        return questionB;
    }

    public String getQuestionA() {
        return questionA;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public String getImageResult() {
        return imageResult;
    }

    public String getResult() {
        return result;
    }

    public String getValueUserChocie() {
        return valueUserChocie;
    }
}
