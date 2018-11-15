package com.android.weekends.modules.destination.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.destination.model.DestinationRequest;
import com.android.weekends.modules.destination.model.DestinationResponse;
import com.android.weekends.network.manager.WeekendRetrofitManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DestinationViewModel extends ViewModel {

    private MutableLiveData<DestinationResponse> destinationResponseMutableLiveData;

    public MutableLiveData<DestinationResponse> setdata(DestinationRequest destinationRequest) {

        if (destinationResponseMutableLiveData == null) {
            destinationResponseMutableLiveData = new MutableLiveData<>();
            setdata1(destinationRequest);

        }
        return destinationResponseMutableLiveData;
    }

    private void setdata1(DestinationRequest destinationRequest) {
        WeekendRetrofitManager.WEEKEN_SERVICE.setdata(destinationRequest).enqueue(new Callback<DestinationResponse>() {
            @Override
            public void onResponse(Call<DestinationResponse> call, Response<DestinationResponse> response) {
                DestinationResponse destinationResponse = response.body();

                if (response.isSuccessful()) {
                    destinationResponseMutableLiveData.setValue(destinationResponse);
                } else {
                    destinationResponseMutableLiveData.setValue(destinationResponse);
                }

            }


            @Override
            public void onFailure(Call<DestinationResponse> call, Throwable t) {
                DestinationResponse destinationResponse = new DestinationResponse();
               // destinationResponse.setMessage(t.getMessage());
                destinationResponseMutableLiveData.setValue(destinationResponse);
            }

        });


    }



}
