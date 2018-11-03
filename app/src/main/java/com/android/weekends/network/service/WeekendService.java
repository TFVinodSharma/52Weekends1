package com.android.weekends.network.service;

import com.android.weekends.modules.login.model.SignUpResponse;
import com.android.weekends.modules.login.model.SignupRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WeekendService {

    @POST("api/register/user/")
    Call<SignUpResponse> registerUser(@Body SignupRequest signupRequest);


}
