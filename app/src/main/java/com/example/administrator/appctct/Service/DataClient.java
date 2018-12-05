package com.example.administrator.appctct.Service;


import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Entity.Profile;
import com.example.administrator.appctct.Entity.ResultQuestion;
import com.example.administrator.appctct.Entity.SectionTest;
import com.example.administrator.appctct.Entity.Student;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.TitleSection;

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

    @FormUrlEncoded
    @POST("question/getdataquestion_gt1.php")
    Call<ArrayList<ModelQuestion>> getQuestionGT1(@Field("test_code") String testCode);

    @GET("question/getdataquestion_gt2.php")
    Call<ArrayList<ModelQuestion>> getQuestionGT2();

    @GET("question/getdataquestion_vl1.php")
    Call<ArrayList<ModelQuestion>> getQuestionVL1();

    @GET("question/getdataquestion_vl2.php")
    Call<ArrayList<ModelQuestion>> getQuestionVL2();


    @FormUrlEncoded
    @POST("getresultquestion_giaitich1.php")
    Call<ResultQuestion> getResult(@Field("id") String id,
                                   @Field("arrid[]") String[] arrID,
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

    //get 20 row in table giai tich 1 for controller activity
    @GET("book/getinfomation/get20rowgiaitich1.php")
    Call<ArrayList<Book>> getDataGiaiTich1();

    //get 20 row in table giai tich 2 for controller activity
    @GET("book/getinfomation/get20rowgiaitich2.php")
    Call<ArrayList<Book>> getDataGiaiTich2();

    //get 20 row in table vat ly 1 for controller activity
    @GET("book/getinfomation/get20rowvatly1.php")
    Call<ArrayList<Book>> getDataVatLy1();

    //get 20 row in table vat ly 2 for controller activity
    @GET("book/getinfomation/get20rowvatly2.php")
    Call<ArrayList<Book>> getDataVatLy2();

    @FormUrlEncoded
    @POST("book/getinfomation/getallgiaitich1.php")
    Call<ArrayList<FullBook>> getAllGiaiTich1(@Field("page") int page);

    @FormUrlEncoded
    @POST("book/getinfomation/getallgiaitich2.php")
    Call<ArrayList<FullBook>> getAllGiaiTich2(@Field("page") int page);

    @FormUrlEncoded
    @POST("book/getinfomation/getallvatly1.php")
    Call<ArrayList<FullBook>> getAllVatLy1(@Field("page") int page);

    @FormUrlEncoded
    @POST("book/getinfomation/getallvatly2.php")
    Call<ArrayList<FullBook>> getAllVatLy2(@Field("page") int page);

    @FormUrlEncoded
    @POST("book/search/searchgiaitich1.php")
    Call<ArrayList<Book>> searchGiaiTich1(@Field("key") String key);

    @FormUrlEncoded
    @POST("book/search/searchgiaitich2.php")
    Call<ArrayList<Book>> searchGiaiTich2(@Field("key") String key);

    @FormUrlEncoded
    @POST("book/search/searchvatly1.php")
    Call<ArrayList<Book>> searchVatLy1(@Field("key") String key);

    @FormUrlEncoded
    @POST("book/search/searchvatly2.php")
    Call<ArrayList<Book>> searchVatLy2(@Field("key") String key);

    @GET("getsection/getsectiontestgt1.php")
    Call<ArrayList<SectionTest>> getSectionTestGT1();

    @GET("getsection/getsectiontestgt2.php")
    Call<ArrayList<SectionTest>> getSectionTestGT2();

    @GET("getsection/getsectiontestvl1.php")
    Call<ArrayList<SectionTest>> getSectionTestVL1();

    @GET("getsection/getsectiontestvl2.php")
    Call<ArrayList<SectionTest>> getSectionTestVL2();

    @GET("question/gettitleoffline_gt1.php")
    Call<ArrayList<TitleSection>> getTitleOfflineGT1();

    @GET("question/gettitleoffline_gt2php")
    Call<ArrayList<TitleSection>> getTitleOfflineGT2();

    @GET("question/gettitleoffline_vl1.php")
    Call<ArrayList<TitleSection>> getTitleOfflineVL1();

    @GET("question/gettitleoffline_vl2.php")
    Call<ArrayList<TitleSection>> getTitleOfflineVL2();
}

