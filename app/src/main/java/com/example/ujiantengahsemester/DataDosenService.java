package com.example.ujiantengahsemester;

import com.example.ujiantengahsemester.Model.Dosen;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataDosenService {
    @GET("/api/progmob/dosen/21")
    Call<ArrayList<Dosen>> getDosenALL(@Path("21") String nimProgmob);

    @FormUrlEncoded
    @POST("/api/progmob/dosen/create")
    Call<DefaultResult>insertDosen(@Field("nama") String nama,
                                 @Field("nidn") String nidn,
                                 @Field("alamat") String alamat,
                                 @Field("email") String email,
                                 @Field("gelar") String gelar,
                                 @Field("foto") String foto,
                                 @Field("nim_progmob") String nim_progmob);

    @POST("/api/progmob/dosen/update")
    Call<DefaultResult>updateDosen(@Field("id") String id,
                                   @Field("nama") String nama,
                                   @Field("nidn") String nidn,
                                   @Field("alamat") String alamat,
                                   @Field("gelar") String gelar,
                                   @Field("foto") String foto,
                                   @Field("nim_progmob") String nim_progmob);

    @POST("api/progmob/dosen/delete")
    Call<DefaultResult>deleteDosen(@Field("id") String id,
                                   @Field("nim_progmob") String nim_progmob);
}