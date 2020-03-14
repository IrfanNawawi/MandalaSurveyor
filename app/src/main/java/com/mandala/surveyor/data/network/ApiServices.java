package com.mandala.surveyor.data.network;

import com.mandala.surveyor.data.db.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("login_mandala.php")
    Call<UserResponse> login(@Header("nik") String nik,
                             @Header("password") String password);

//    @GET("mitrawangi/api/gedung/getrows")
//    Call<List<GedungResponse>> getGedung();
//
//    @POST("mitrawangi/api/client/insert")
//    Call<ClientResponse> insertClient(@Body List<Client> item);
//
//    @Headers("Content-Type: application/json; charset=UTF-8")
//    @POST("mitrawangi/api/operasionalacara/insert")
//    Call<AcaraRespon> insertOpsAcara(@Body List<Acara> item);
//
//    @GET("mitrawangi/api/client/getrows/")
//    Call<ClientAllResponse> getAllClient();
}
