package com.example.administrator.appctct.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultQuestion implements Parcelable {
    @SerializedName("point")
    @Expose
    private String point;

    @SerializedName("ratio")
    @Expose
    private String ratio;

    @SerializedName("rate")
    @Expose
    private String rate;

    protected ResultQuestion(Parcel in) {
        point = in.readString();
        ratio = in.readString();
        rate = in.readString();
    }

    public static final Creator<ResultQuestion> CREATOR = new Creator<ResultQuestion>() {
        @Override
        public ResultQuestion createFromParcel(Parcel in) {
            return new ResultQuestion(in);
        }

        @Override
        public ResultQuestion[] newArray(int size) {
            return new ResultQuestion[size];
        }
    };

    public String getPoint() {
        return point;
    }

    public String getRate() {
        return rate;
    }

    public String getRatio() {
        return ratio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(point);
        dest.writeString(ratio);
        dest.writeString(rate);
    }
}
