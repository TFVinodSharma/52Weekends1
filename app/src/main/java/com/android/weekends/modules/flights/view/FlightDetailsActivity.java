package com.android.weekends.modules.flights.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.database.AppState;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.login.view.LoginActivity;
import com.android.weekends.modules.payments.view.PaymentMethodActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;

public class FlightDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight__details);
    }

    public void Gotologinuserflight(View v)
    {
        Intent intent;
        if (AppState.getInstance(FlightDetailsActivity.this).getUserToken() == null) {
            intent = new Intent(FlightDetailsActivity.this, LoginActivity.class);
        } else {
            intent = new Intent(FlightDetailsActivity.this, PaymentMethodActivity.class);
        }
        startActivity(intent);

    }
}
