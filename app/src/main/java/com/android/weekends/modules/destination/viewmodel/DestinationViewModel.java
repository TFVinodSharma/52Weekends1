package com.android.weekends.modules.destination.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.destination.model.DestinationResponse;
import com.android.weekends.network.manager.WeekendRetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DestinationViewModel extends ViewModel {

    private MutableLiveData<DestinationResponse> destinationResponseMutableLiveData;


    public MutableLiveData<DestinationResponse> getDestinations() {
        destinationResponseMutableLiveData = new MutableLiveData();
        getDestinationsData();

        return destinationResponseMutableLiveData;
    }


    private void getDestinationsData() {
        WeekendRetrofitManager.WEEKEND_SERVICE.getDestinations().enqueue(new Callback<DestinationResponse>() {
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
                destinationResponseMutableLiveData.setValue(destinationResponse);
            }
        });
    }

}
