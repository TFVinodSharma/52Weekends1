package com.android.weekends.modules.home.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.database.AppState;
import com.android.weekends.databinding.ActivityHomePageBinding;
import com.android.weekends.modules.buses.view.BusSearchActivity;
import com.android.weekends.modules.destination.adapter.DestinationAdapter;
import com.android.weekends.modules.destination.view.DestinationActivity;
import com.android.weekends.modules.destination.viewmodel.DestinationViewModel;
import com.android.weekends.modules.hotels.view.HotelSearchActivity;
import com.android.weekends.modules.login.view.LoginActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;
import com.android.weekends.modules.selectpackage.adapter.DomesticSelectPackageAdapter;
import com.android.weekends.modules.selectpackage.adapter.InternationalSelectPackageAdapter;
import com.android.weekends.modules.selectpackage.view.SelectPacakge;
import com.android.weekends.modules.home.adapter.TopDestinationAdapter;
import com.android.weekends.modules.home.adapter.InternationalPackageAdapter;
import com.android.weekends.modules.home.adapter.DomesticPackageAdapter;
import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.flights.view.FlightActivity;
import com.android.weekends.modules.selectpackage.viewmodel.DomesticPackageViewModel;
import com.android.weekends.modules.selectpackage.viewmodel.InternationalPackageViewModel;
import com.android.weekends.modules.trip.view.TripActivity;


public class HomePageActivity extends BaseActivity implements View.OnClickListener {

    ActivityHomePageBinding activityHomePageBinding;

    LinearLayout GotoFlightActivity, GotoBusActivity, GotoHotelActivity, GotoDestination, GotoTrip, GotoProfile, GotoPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomePageBinding = DataBindingUtil.setContentView(this, R.layout.activity_home__page);

        GotoFlightActivity = findViewById(R.id.gotoflightactivity);
        GotoBusActivity = findViewById(R.id.gotobusactivity);
        GotoHotelActivity = findViewById(R.id.gotohotelacitivity);
        GotoDestination = findViewById(R.id.desination);
        GotoTrip = findViewById(R.id.tripP);
        GotoPackage = findViewById(R.id.flightpackage);
        GotoProfile = findViewById(R.id.response);


        GotoFlightActivity.setOnClickListener(this);
        GotoBusActivity.setOnClickListener(this);
        GotoHotelActivity.setOnClickListener(this);
        GotoDestination.setOnClickListener(this);
        GotoTrip.setOnClickListener(this);
        GotoPackage.setOnClickListener(this);
        GotoProfile.setOnClickListener(this);

        getDestinations();
        getDomesticPackage();
        getinternationalpackage();

    }


    private void getDomesticPackage() {
        showProgressDialogue();
        DomesticPackageViewModel domesticPackageViewModel = ViewModelProviders.of(this).get(DomesticPackageViewModel.class);
        domesticPackageViewModel.getdomesticpackage().observe(this, domesticPackageResponse -> {
            hideProgressDialgogue();

            if (domesticPackageResponse.getdomesticpackage() != null) {
                DomesticSelectPackageAdapter domesticPackageAdapter = new DomesticSelectPackageAdapter(domesticPackageResponse.getdomesticpackage());
                RecyclerView recyclerViewDPA = findViewById(R.id.rv_domestic);
               /* domesticPackageAdapter.isHorizontal = true;

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                domesticPackageAdapter.widthPixels = displayMetrics.widthPixels;
               */
               recyclerViewDPA.setAdapter(domesticPackageAdapter);
            } else {
                showErrorMessage(domesticPackageResponse.getMessage());
            }

        });

    }

    private void getinternationalpackage() {
        InternationalPackageViewModel internationalPackageViewModel = ViewModelProviders.of(this).get(InternationalPackageViewModel.class);
        internationalPackageViewModel.getinternationalpackage().observe(this, internationalPackageResponse -> {
            hideProgressDialgogue();

            if (internationalPackageResponse.getinternationalpackage() != null) {
                InternationalSelectPackageAdapter internationalPackageAdapter = new InternationalSelectPackageAdapter(internationalPackageResponse.getinternationalpackage());
                RecyclerView recyclerViewIPA = findViewById(R.id.rv_international);
                recyclerViewIPA.setAdapter(internationalPackageAdapter);

            } else {
                showErrorMessage(internationalPackageResponse.getMessage());
            }

        });

    }

    private void getDestinations() {

        DestinationViewModel destinationViewModel = ViewModelProviders.of(this).get(DestinationViewModel.class);

        destinationViewModel.getDestinations().observe(this, destinationResponse -> {
            hideProgressDialgogue();

            if (destinationResponse.getDestinations() != null) {
                DestinationAdapter destinationAdapter = new DestinationAdapter(destinationResponse.getDestinations());
                RecyclerView destinationrecycler = findViewById(R.id.rv_destinations);
               /* destinationrecycler.setHasFixedSize(true);
                destinationrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
               */ destinationrecycler.setAdapter(destinationAdapter);
            } else {
                showErrorMessage(destinationResponse.getMessage());
            }

        });

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // for bottom bar
            case R.id.response:
                Intent intent;
                //TODO need to have token in registeration as well.
                if (AppState.getInstance(HomePageActivity.this).getUserToken() == null) {
                    intent = new Intent(HomePageActivity.this, LoginActivity.class);
                } else {
                    intent = new Intent(HomePageActivity.this, ProfileActivity.class);
                }
                startActivity(intent);
                break;

            case R.id.tripP:
                if (AppState.getInstance(HomePageActivity.this).getUserToken() == null) {
                    intent = new Intent(HomePageActivity.this, LoginActivity.class);
                } else {
                    intent = new Intent(HomePageActivity.this, TripActivity.class);
                }
                startActivity(intent);
                break;
            case R.id.desination:
                Intent intent2 = new Intent(this, DestinationActivity.class);
                this.startActivity(intent2);
                break;
            // close bottom bar
            case R.id.gotoflightactivity:
                Intent intent3 = new Intent(this, FlightActivity.class);
                this.startActivity(intent3);
                break;

            case R.id.gotobusactivity:
                Intent intent4 = new Intent(this, BusSearchActivity.class);
                this.startActivity(intent4);
                break;

            case R.id.gotohotelacitivity:
                Intent intent5 = new Intent(this, HotelSearchActivity.class);
                this.startActivity(intent5);
                break;

            case R.id.flightpackage:
                Intent intent6 = new Intent(this, SelectPacakge.class);
                this.startActivity(intent6);
                break;

        }

    }
}
