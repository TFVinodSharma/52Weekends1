package com.android.weekends.base.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.android.weekends.R;
import com.android.weekends.base.BaseActivity;
import com.android.weekends.modules.login.view.Login;

public class Splash extends BaseActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Login.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
