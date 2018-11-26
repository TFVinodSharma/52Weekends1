package com.android.weekends.modules.hotels.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.flights.view.FlightActivity;

import java.util.Calendar;

public class HotelSearchActivity extends BaseActivity {


    private TextView checkindate, checkoutdate;

    private static String TAG = "HotelSearchActivity";

    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        Toolbar Hotelsearchtoolbar=(Toolbar)findViewById(R.id.hotlesearchtoolbar);
        setSupportActionBar(Hotelsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hotel Search");



        checkindate = findViewById(R.id.txt_checkin_date);
        checkoutdate = findViewById(R.id.txt_checkout_date);

        checkindate.setOnClickListener(view -> {
            ChooseDate(view.getId());
        });

        checkoutdate.setOnClickListener(view -> ChooseDate(view.getId()));

        mDateSetListener = (datePicker, year, month, day) -> {
            int tagId = (int) datePicker.getTag();
            String date = month + 1 + "/" + day + "/" + year;
            switch (tagId) {
                case R.id.txt_checkin_date:
                    checkindate.setText(date);
                    break;

                case R.id.txt_checkout_date:
                    checkoutdate.setText(date);
                    break;
            }

        };



        TextView setguest=(TextView)findViewById(R.id.txt_no_guest);
        TextView setroom=(TextView)findViewById(R.id.txt_no_room);

        Bundle b1 = getIntent().getExtras();

        if (b1 != null)
        {
            setguest.setText(" "+b1.getString("Key"));
        }
        else
        {
            setroom.setText(" "+b1.getString("Key"));
        }

        Button Hotelsearch=(Button)findViewById(R.id.button_search);
        Hotelsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HotelListActivity.class);
                startActivity(i);
            }
        });

        final LinearLayout Hotelguestselection=(LinearLayout)findViewById(R.id.selectguest);
        Hotelguestselection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),HotelGuestSlectionActivity.class);
                startActivity(i);

            }
        });

        LinearLayout HotelRoomSearch=(LinearLayout)findViewById(R.id.roomssearch);
        HotelRoomSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HotelGuestSlectionActivity.class);
                startActivity(i);

            }
        });


    }


    public void ChooseDate(int id) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(HotelSearchActivity.this,/*R.style.Datepicker,*/
                mDateSetListener,
                year, month, date);
        dialog.getWindow();
                //.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
        dialog.show();

        DatePicker datePicker = dialog.getDatePicker();
        datePicker.setTag(id);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
