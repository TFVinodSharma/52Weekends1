package com.android.weekends.modules.hotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.BaseActivity;

public class HotelSearch extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        Toolbar Hotelsearchtoolbar=(Toolbar)findViewById(R.id.hotlesearchtoolbar);
        setSupportActionBar(Hotelsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hotel Search");


        TextView setguest=(TextView)findViewById(R.id.txt_no_guest);
        TextView setroom=(TextView)findViewById(R.id.txt_no_room);

        Bundle b1 = getIntent().getExtras();

        if (b1 != null)
        {
            setguest.setText(" "+b1.getString("Key"));
        }
        /*else
        {
            setroom.setText(" "+b1.getString("Key"));
        }*/

        Button Hotelsearch=(Button)findViewById(R.id.button_search);
        Hotelsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HotelList.class);
                startActivity(i);
            }
        });

        final LinearLayout Hotelguestselection=(LinearLayout)findViewById(R.id.selectguest);
        Hotelguestselection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),HotelGuestSlection.class);
                startActivity(i);

            }
        });

        LinearLayout HotelRoomSearch=(LinearLayout)findViewById(R.id.roomssearch);
        HotelRoomSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HotelGuestSlection.class);
                startActivity(i);

            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
