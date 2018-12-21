package com.example.administrator.appctct.Entity.RateBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitleCommentSeeAll {
    @SerializedName("rate_num")
    @Expose
    private RateNum rateNum;

    @SerializedName("detail_rate_num")
    @Expose
    private DetailRateNum detailRateNum;

    public DetailRateNum getDetailRateNum() {
        return detailRateNum;
    }

    public RateNum getRateNum() {
        return rateNum;
    }
}
