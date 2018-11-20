package com.android.weekends.modules.flights.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.login.view.LoginActivity;

public class FlightDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight__details);
    }

    public void Gotologinuserflight(View v)
    {
        Intent i= new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
