package com.android.weekends.modules.tourdetails.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.base.fragment.FragAboutPlacce;
import com.android.weekends.base.fragment.FragStayInfo;
import com.android.weekends.base.fragment.FragTourHighlights;
import com.android.weekends.base.fragment.FragTransportaion;
import com.android.weekends.base.fragment.FragItinerary;

import java.util.ArrayList;

public class PackageDetails extends BaseActivity {
    ViewPager viewPager;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package__details);

        Toolbar PacakageDetailsToolBar=(Toolbar)findViewById(R.id.pacakgedetailstoolbar);
        setSupportActionBar(PacakageDetailsToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // setTitle("Hotel Search");



        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("ABOUT PLACE"));
        tabLayout.addTab(tabLayout.newTab().setText("ITINERARY"));
        tabLayout.addTab(tabLayout.newTab().setText("STAY INFO"));
        tabLayout.addTab(tabLayout.newTab().setText("TRANSPORTATION"));
        tabLayout.addTab(tabLayout.newTab().setText("TOUR HIGHLITS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    class MyAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list = new ArrayList<>();
        public MyAdapter(FragmentManager fm) {
            super(fm);
            list.add(new FragAboutPlacce());
            list.add(new FragItinerary());
            list.add(new FragStayInfo());
            list.add(new FragTransportaion());
            list.add(new FragTourHighlights());
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
