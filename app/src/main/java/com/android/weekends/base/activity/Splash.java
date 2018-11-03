package com.android.weekends.base.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.android.weekends.R;
import com.android.weekends.modules.login.view.LoginActivity;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class Splash extends BaseActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(Splash.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
