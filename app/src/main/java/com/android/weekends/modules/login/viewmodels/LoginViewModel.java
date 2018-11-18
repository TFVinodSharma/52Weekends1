package com.android.weekends.modules.login.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.login.model.LoginRequest;
import com.android.weekends.modules.login.model.LoginResponse;
import com.android.weekends.network.manager.WeekendRetrofitManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginResponse> loginLiveDataResponse;

    public MutableLiveData<LoginResponse> loginUser(LoginRequest loginRequest) {
        loginLiveDataResponse = new MutableLiveData<>();
        doLogin(loginRequest);
        return loginLiveDataResponse;
    }


    private void doLogin(LoginRequest loginRequest) {

        HashMap<String, String> loginRequestHashMap = new Gson().fromJson(
                new Gson().toJson(loginRequest), new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );

        WeekendRetrofitManager.WEEKEND_SERVICE.loginUser(loginRequestHashMap).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (response.isSuccessful()) {
                    loginLiveDataResponse.setValue(loginResponse);
                } else {
                    loginLiveDataResponse.setValue(loginResponse);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMessage(t.getMessage());
                loginLiveDataResponse.setValue(loginResponse);
            }
        });

    }
}
