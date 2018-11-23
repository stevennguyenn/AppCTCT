package com.example.administrator.appctct.Service;


import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.Entity.Profile;
import com.example.administrator.appctct.Entity.Student;
import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DataClient {
    @Multipart
    @POST("uploadimage.php")
    Call<String> uploadImage(@Part MultipartBody.Part photo);

    @FormUrlEncoded
    @POST("insertDatabase.php")
    Call<String> insertData(@Field("fullname") String fullname,
                            @Field("account") String account,
                            @Field("password") String password,
                            @Field("avatar") String avatar);

    @FormUrlEncoded
    @POST("login.php")
    Call<Student> login(@Field("account") String account,
                        @Field("password") String password);

    @GET("getdataquestion.php")
    Call<ArrayList<ModelQuestion>> getQuestion();

    @FormUrlEncoded
    @POST("getresultquestion.php")
    Call<Integer> getResult(@Field("arrid[]") String[] arrID,
                            @Field("arrresult[]") String[] arrResult);

    @FormUrlEncoded
    @POST("getresultquestion.php")
    Call<String> getResultTemp(@Field("arrid[]") String[] arrID,
                            @Field("arrresult[]") String[] arrResult);

    @FormUrlEncoded
    @POST("changpassword.php")
    Call<String> changePassword(@Field("id") String id,
                                @Field("currentPassword") String currentPassword,
                                @Field("newPassword") String newPassword);

    @FormUrlEncoded
    @POST("profile.php")
    Call<Profile> getProfile(@Field("id") String id);

    @FormUrlEncoded
    @POST("findcode_ctct.php")
    Call<String> findCode(@Field("id") String id,
                          @Field("code") String code);

    @FormUrlEncoded
    @POST("getcontentheadernavi.php")
    Call<ContentHeader> getContentHeader(@Field("id") String id);
}
