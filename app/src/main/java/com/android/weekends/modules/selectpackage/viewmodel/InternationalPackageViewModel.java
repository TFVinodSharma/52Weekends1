package com.android.weekends.modules.selectpackage.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.selectpackage.model.InternationalPackageResponse;
import com.android.weekends.network.manager.WeekendRetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternationalPackageViewModel extends ViewModel {

    private MutableLiveData<InternationalPackageResponse> internationalPackageResponseMutableLiveData;

    public MutableLiveData<InternationalPackageResponse> getinternationalpackage() {
        internationalPackageResponseMutableLiveData = new MutableLiveData();
        getInternationalPackageData();
        return internationalPackageResponseMutableLiveData;

    }

    private void getInternationalPackageData() {
        WeekendRetrofitManager.WEEKEND_SERVICE.getinternationalpackage().enqueue(new Callback<InternationalPackageResponse>() {
            @Override
            public void onResponse(Call<InternationalPackageResponse> call, Response<InternationalPackageResponse> response) {
                InternationalPackageResponse internationalPackageResponse = response.body();
                if (response.isSuccessful()) {
                    internationalPackageResponseMutableLiveData.setValue(internationalPackageResponse);
                } else {
                    internationalPackageResponseMutableLiveData.setValue(internationalPackageResponse);
                }
            }

            @Override
            public void onFailure(Call<InternationalPackageResponse> call, Throwable t) {
                InternationalPackageResponse internationalPackageResponse = new InternationalPackageResponse();
                internationalPackageResponseMutableLiveData.setValue(internationalPackageResponse);
            }
        });
    }



}
