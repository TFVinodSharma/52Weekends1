package com.android.weekends.network.manager;

import android.os.Debug;

import com.android.weekends.BuildConfig;
import com.android.weekends.constants.AppConstants;
import com.android.weekends.network.service.WeekendService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeekendRetrofitManager {

    private static final int TIME_OUT = 1;
    public static final WeekendService WEEKEN_SERVICE;

    static {

        OkHttpClient.Builder weekendCLientBuilder = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.MINUTES)
                .writeTimeout(TIME_OUT, TimeUnit.MINUTES)
                .connectTimeout(TIME_OUT, TimeUnit.MINUTES);

        if (BuildConfig.DEBUG) {
            weekendCLientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(weekendCLientBuilder.build()).build();

        WEEKEN_SERVICE = retrofit.create(WeekendService.class);

    }

}
