package com.example.administrator.appctct.Service;

public class APIUtils {
    public static final String baseURL = "http:/10.20.79.128/CTCT/";

    public static DataClient getData(){
        return RetrofitClient.getClient(baseURL).create(DataClient.class);
    }
}