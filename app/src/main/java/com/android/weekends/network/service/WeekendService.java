package com.android.weekends.network.service;

import com.android.weekends.base.response.BaseResponse;
import com.android.weekends.modules.login.model.SignupRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WeekendService {

    @POST("api/register/user/")
    Call<BaseResponse> registerUser(@Body SignupRequest signupRequest);


}
