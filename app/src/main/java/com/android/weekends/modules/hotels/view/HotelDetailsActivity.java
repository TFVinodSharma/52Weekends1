package com.android.weekends.modules.hotels.view;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.weekends.modules.hotels.adapter.PagerHotelAdapter;
import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class HotelDetailsActivity extends BaseActivity {
PagerHotelAdapter pagerHotel_adapter;
ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel__details);

        Toolbar HotelDetailstoolbar=(Toolbar)findViewById(R.id.hoteldetailstoolbar);
        setSupportActionBar(HotelDetailstoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hotel Search");


        pagerHotel_adapter = new PagerHotelAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.image_pager);
        mViewPager.setAdapter(pagerHotel_adapter);




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
