package com.android.weekends.modules.profile.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.weekends.R;
import com.android.weekends.database.AppState;
import com.android.weekends.modules.destination.view.DestinationActivity;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.login.view.LoginActivity;
import com.android.weekends.modules.trip.view.TripActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    LinearLayout DestinationLayout1, HomeLayout1, TripLayout1;

    /*TextView UserName;
    TextView UserMobile;
    TextView UserAddress;
    TextView UserCity;
    TextView UserEmail;
    TextView UserPinCode;

    private String SHARED_PREFS_NAME = "com.android.weekends";

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar ProfileToolBar = (Toolbar) findViewById(R.id.profiletoolbar);
        setSupportActionBar(ProfileToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Profile");
       /* UserName=findViewById(R.id.user_profile_name);
        UserMobile=findViewById(R.id.txt_mobile);
        UserAddress=findViewById(R.id.txt_address);
        UserCity=findViewById(R.id.txt_city);
        UserEmail=findViewById(R.id.user_email);
        UserPinCode=findViewById(R.id.txt_pincode);
*/
        DestinationLayout1 = findViewById(R.id.desination);
        HomeLayout1 = findViewById(R.id.homeP);
        TripLayout1 = findViewById(R.id.tripP);
        ImageView Logout = findViewById(R.id.logoutimage);


        DestinationLayout1.setOnClickListener(this);
        HomeLayout1.setOnClickListener(this);
        TripLayout1.setOnClickListener(this);



/*
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            UserName = (TextView) prefs.getStringSet("name", null);//"No name defined" is the default value.
            UserPinCode = (TextView) prefs.getStringSet("pincode",null); //0 is the default value.
            UserEmail= (TextView) prefs.getStringSet("email",null);
            UserAddress= (TextView) prefs.getStringSet("address",null);
            UserMobile= (TextView) prefs.getStringSet("phone",null);
            UserCity= (TextView) prefs.getStringSet("city",null);
        }
*/

        /*Bundle setBundle=getIntent().getExtras();
        if (setBundle!=null)
        {
            UserName.setText(setBundle.getString("name"));
            UserPinCode.setText(setBundle.getString("pincode"));
            UserEmail.setText(setBundle.getString("email"));
            UserAddress.setText(setBundle.getString("address"));
            UserMobile.setText(setBundle.getString("phone"));
            UserCity.setText(setBundle.getString("city"));
        }*/

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                /*SharedPreferences preferences =getSharedPreferences("loginPrefs",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();*/
                intent= new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
               // finish();
/*
                AppState.setUserToken(getApplicationContext(), false);

                // Logout
                logout();
*/
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.desination:
                Intent intent = new Intent(this, DestinationActivity.class);
                this.startActivity(intent);
                break;

            case R.id.homeP:
                Intent intent1 = new Intent(this, HomePageActivity.class);
                this.startActivity(intent1);
                break;
            case R.id.tripP:
                Intent intent2 = new Intent(this, TripActivity.class);
                this.startActivity(intent2);
                break;

        }

    }



}
