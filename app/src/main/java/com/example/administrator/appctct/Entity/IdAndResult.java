package com.example.administrator.appctct.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class IdAndResult implements Parcelable {

    private String id;
    private String result;
    private String contentResult;
    private int position;

    public IdAndResult(String id){
        this.id = id;
        this.result = "";
        this.contentResult = "";
        this.position = -1;
    }

    public IdAndResult(String id, String result,String contentResult,int position) {
        this.id = id;
        this.result = result;
        this.contentResult = contentResult;
        this.position = position;
    }

    protected IdAndResult(Parcel in) {
        id = in.readString();
        result = in.readString();
        contentResult = in.readString();
        position = in.readInt();
    }

    public static final Creator<IdAndResult> CREATOR = new Creator<IdAndResult>() {
        @Override
        public IdAndResult createFromParcel(Parcel in) {
            return new IdAndResult(in);
        }

        @Override
        public IdAndResult[] newArray(int size) {
            return new IdAndResult[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(result);
        dest.writeString(contentResult);
        dest.writeInt(position);
    }
}
