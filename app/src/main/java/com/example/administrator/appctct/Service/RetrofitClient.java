package com.example.administrator.appctct.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseURL){
        if (retrofit == null) {
        OkHttpClient builder = new OkHttpClient.Builder()
                                            .readTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
                                            .writeTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
                                            .connectTimeout(10000, java.util.concurrent.TimeUnit.MILLISECONDS)
                                            .retryOnConnectionFailure(true)
                                            .build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .client(builder)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
