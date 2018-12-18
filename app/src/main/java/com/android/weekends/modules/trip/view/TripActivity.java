package com.android.weekends.modules.trip.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.destination.view.DestinationActivity;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;
import com.android.weekends.modules.trip.fragment.CancelledFragment;
import com.android.weekends.modules.trip.fragment.CompletedFragment;
import com.android.weekends.modules.trip.fragment.UpcomingFragment;

import java.util.ArrayList;

public class TripActivity extends BaseActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        Toolbar TripToolBar=(Toolbar)findViewById(R.id.triptoolbar);
        setSupportActionBar(TripToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("My Trip");

        LinearLayout DestinationLayout=(LinearLayout)findViewById(R.id.desination);
        LinearLayout HomeLayout=(LinearLayout)findViewById(R.id.homeP);
        LinearLayout ProfileLayout=(LinearLayout)findViewById(R.id.response);

        DestinationLayout.setOnClickListener(this);
        HomeLayout.setOnClickListener(this);
        ProfileLayout.setOnClickListener(this);

        ViewPager viewPage;
        TabLayout Tab=(TabLayout)findViewById(R.id.tab);
        Tab.addTab(Tab.newTab().setText("UPCOMING"));
        Tab.addTab(Tab.newTab().setText("COMPLETED"));
        Tab.addTab(Tab.newTab().setText("CANCELLED"));
        Tab.setTabGravity(TabLayout.GRAVITY_CENTER);

        TripAdapter adapter1 = new TripAdapter(getSupportFragmentManager());
        viewPage = findViewById(R.id.viewpage);
        viewPage.setAdapter(adapter1);

        viewPage.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(Tab));
        Tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
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
        switch (v.getId())
        {
            case  R.id.response :
                Intent i= new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(i);
                break;
            case R.id.homeP:
                Intent i1= new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(i1);
                break;

            case R.id.desination:
                Intent i2= new Intent(getApplicationContext(),DestinationActivity.class);
                startActivity(i2);
                break;


        }
    }

    class TripAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list = new ArrayList<>();
        public TripAdapter(FragmentManager fm) {
            super(fm);
            list.add(new UpcomingFragment());
            list.add(new CompletedFragment());
            list.add(new CancelledFragment());
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
    }

}
