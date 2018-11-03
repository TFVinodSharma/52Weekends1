package com.android.weekends.modules.hotels.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.weekends.modules.hotels.adapter.HotelListAdapter;
import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class HotelListActivity extends BaseActivity {
    public  String[] HotelName={"Karni Fort","Raj Mohan","Sat Sitra","Hayat","Taj","Sraton"};
    public  String[] HotelAddress={"Chattarpur New Delhi","Janta Colony Jaipur","Alwar Rajasthan","Navi Mumbai","New Delhi","Saket New Delhi"};
    public String[] HotelAmount={"2000","3000","2500","5000","7000","5500"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel__list);

        Toolbar HotelListToolbar=(Toolbar)findViewById(R.id.hotellisttoolbar);
        setSupportActionBar(HotelListToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setTitle("Hotel Search");


        RecyclerView RecyclerHotelList=(RecyclerView)findViewById(R.id.recycler_hotel_list);
        RecyclerHotelList.setLayoutManager(new LinearLayoutManager(this));
        RecyclerHotelList.setHasFixedSize(true);
        RecyclerHotelList.setAdapter(new HotelListAdapter(HotelName, HotelAddress,HotelAmount));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
