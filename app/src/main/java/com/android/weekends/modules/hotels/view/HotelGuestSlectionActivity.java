package com.android.weekends.modules.hotels.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class HotelGuestSlectionActivity extends BaseActivity  {
    int minteger = 0;
    TextView displayInteger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_guest_slection);

        Toolbar HotelGuestToolBar=(Toolbar)findViewById(R.id.hotelroomselect);
        setSupportActionBar(HotelGuestToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Select room and guest");


        displayInteger = (TextView) findViewById(
                R.id.noofguest);




        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.setvalueonguest);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(getApplicationContext(),HotelSearchActivity.class);
                Bundle b=new Bundle();
                b.putString("Key", String.valueOf(displayInteger.getText().toString()));

                in.putExtras(b);
                startActivity(in);
            }
        });

    }


    public void increaseInteger(View view) {
        if (minteger<5)
        {
            minteger = minteger + 1;
            display(minteger);

        }
        else
        {
            Toast toast = Toast.makeText(this,"up to 5 Guest allowed in one room", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }

    }
    public void decreaseInteger(View view) {

        if (minteger>0)
        {
            minteger = minteger - 1;
            display(minteger);

        }


    }

    private void display(int number) {
        displayInteger.setText("" + number);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}

