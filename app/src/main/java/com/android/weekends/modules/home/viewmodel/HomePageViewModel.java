package com.android.weekends.modules.home.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.weekends.modules.destination.model.DestinationResponse;
import com.android.weekends.modules.selectpackage.model.DomesticPackageResponse;
import com.android.weekends.modules.selectpackage.model.InternationalPackageResponse;
import com.android.weekends.network.manager.WeekendRetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageViewModel extends ViewModel {

    private MutableLiveData<DomesticPackageResponse> domesticPackageResponseMutableLiveData;

    private MutableLiveData<InternationalPackageResponse> internationalPackageResponseMutableLiveData;

    private MutableLiveData<DestinationResponse> destinationResponseMutableLiveData;



    public MutableLiveData<DomesticPackageResponse> getdomesticpackage() {
        domesticPackageResponseMutableLiveData = new MutableLiveData<DomesticPackageResponse>();
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

    public MutableLiveData<DestinationResponse> getDestinations() {
        destinationResponseMutableLiveData = new MutableLiveData<DestinationResponse>();
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
