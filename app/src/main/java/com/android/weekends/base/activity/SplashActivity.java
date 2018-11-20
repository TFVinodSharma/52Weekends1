package com.android.weekends.base.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.Spinner;

import com.android.weekends.R;
import com.android.weekends.database.AppState;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.login.view.LoginActivity;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class SplashActivity extends BaseActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            Intent intent;

            intent = new Intent(SplashActivity.this, HomePageActivity.class);
            /*//TODO need to have token in registeration as well.
            if (AppState.getInstance(SplashActivity.this).getUserToken() == null) {
                intent = new Intent(SplashActivity.this, LoginActivity.class);
            } else {
                intent = new Intent(SplashActivity.this, HomePageActivity.class);
            }*/
            startActivity(intent);
            finish();
        }, SPLASH_TIME_OUT);

    }
}
