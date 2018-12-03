package com.example.administrator.appctct.Entity;

import java.io.Serializable;

public class IdAndResult implements Serializable {

    private String id;
    private String result;
    private String contentResult;
    private int position;

    public IdAndResult(String id, String result,String contentResult,int position) {
        this.id = id;
        this.result = result;
        this.contentResult = contentResult;
        this.position = position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setContentResult(String contentResult) {
        this.contentResult = contentResult;
    }

    public String getContentResult() {
        return contentResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
