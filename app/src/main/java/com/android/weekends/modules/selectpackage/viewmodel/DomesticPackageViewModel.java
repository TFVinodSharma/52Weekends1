package com.android.weekends.modules.selectpackage.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.destination.model.DestinationResponse;
import com.android.weekends.modules.selectpackage.model.DomesticPackageResponse;
import com.android.weekends.network.manager.WeekendRetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DomesticPackageViewModel extends ViewModel {

    private MutableLiveData<DomesticPackageResponse> domesticPackageResponseMutableLiveData;

    public MutableLiveData<DomesticPackageResponse> getdomesticpackage() {
        domesticPackageResponseMutableLiveData = new MutableLiveData();
        getDomesticPackageData();

        return domesticPackageResponseMutableLiveData;


    }

    private void getDomesticPackageData() {
        WeekendRetrofitManager.WEEKEND_SERVICE.getdomesticpackage().enqueue(new Callback<DomesticPackageResponse>() {
            @Override
            public void onResponse(Call<DomesticPackageResponse> call, Response<DomesticPackageResponse> response) {
                DomesticPackageResponse domesticPackageResponse = response.body();
                if (response.isSuccessful()) {
                    domesticPackageResponseMutableLiveData.setValue(domesticPackageResponse);
                } else {
                    domesticPackageResponseMutableLiveData.setValue(domesticPackageResponse);
                }
            }

            @Override
            public void onFailure(Call<DomesticPackageResponse> call, Throwable t) {
                DomesticPackageResponse domesticPackageResponse = new DomesticPackageResponse();
                domesticPackageResponseMutableLiveData.setValue(domesticPackageResponse);
            }
        });
    }

}
