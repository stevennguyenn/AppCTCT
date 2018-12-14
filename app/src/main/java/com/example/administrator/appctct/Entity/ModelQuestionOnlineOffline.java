package com.example.administrator.appctct.Entity;

import android.graphics.ColorSpace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelQuestionOnlineOffline {
    @SerializedName("test_code")
    @Expose
    private String testCode;

    @SerializedName("list_question")
    @Expose
    private ArrayList<ModelQuestion> listQuestion;

    public ArrayList<ModelQuestion> getListQuestion() {
        return listQuestion;
    }

    public String getTestCode() {
        return testCode;
    }
}
