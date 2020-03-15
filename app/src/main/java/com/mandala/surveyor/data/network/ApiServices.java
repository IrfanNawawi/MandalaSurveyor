package com.mandala.surveyor.data.network;

import com.mandala.surveyor.data.db.models.Penugasan;
import com.mandala.surveyor.data.db.response.PenugasanResponse;
import com.mandala.surveyor.data.db.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("users/login")
    Call<UserResponse> login(@Header("nik") String nik,
                             @Header("password") String password);

    @GET("mmf_trx_ps")
    Call<PenugasanResponse> getPenugasan();
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
