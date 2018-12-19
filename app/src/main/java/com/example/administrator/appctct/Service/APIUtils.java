package com.example.administrator.appctct.Service;

public class APIUtils {
    public static final String baseURL = "http:/192.168.1.205/CTCT/";

    public static DataClient getData(){
        return RetrofitClient.getClient(baseURL).create(DataClient.class);
    }
}
