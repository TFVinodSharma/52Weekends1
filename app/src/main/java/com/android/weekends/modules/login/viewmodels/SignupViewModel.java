package com.android.weekends.modules.login.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.login.model.SignUpResponse;
import com.android.weekends.modules.login.model.SignupRequest;
import com.android.weekends.network.manager.WeekendRetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupViewModel extends ViewModel {

    private MutableLiveData<SignUpResponse> signupLiveDataResponse;


    public LiveData<SignUpResponse> registerUser(SignupRequest signupRequest) {

        if (signupLiveDataResponse == null) {
            signupLiveDataResponse = new MutableLiveData<SignUpResponse>();
            doRegisteration(signupRequest);
        }
        return signupLiveDataResponse;
    }

    private void doRegisteration(SignupRequest signupRequest) {

        WeekendRetrofitManager.WEEKEN_SERVICE.registerUser(signupRequest).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                SignUpResponse signUpResponse = response.body();

                if (response.isSuccessful()) {
                    signupLiveDataResponse.setValue(signUpResponse);
                }else{
                    signupLiveDataResponse.setValue(signUpResponse);
                }

            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                SignUpResponse signUpResponse = new SignUpResponse();
                signUpResponse.setMessage(t.getMessage());
                signupLiveDataResponse.setValue(signUpResponse);
            }
        });
    }
}
