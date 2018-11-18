package com.android.weekends.network.service;

import com.android.weekends.modules.destination.model.DestinationResponse;
import com.android.weekends.modules.login.model.LoginResponse;
import com.android.weekends.modules.login.model.SignUpResponse;
import com.android.weekends.modules.login.model.SignupRequest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WeekendService {

    @POST("api/register/user/")
    Call<SignUpResponse> registerUser(@Body SignupRequest signupRequest);


    @FormUrlEncoded
    @POST("api/register/login/")
    Call<LoginResponse> loginUser(@FieldMap Map<String, String> loginRequest);

    @GET("api/destinations/destination/")
    Call<DestinationResponse> getDestinations();


}
