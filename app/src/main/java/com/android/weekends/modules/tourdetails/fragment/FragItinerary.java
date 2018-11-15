package com.android.weekends.modules.tourdetails.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.weekends.modules.tourdetails.adapter.FragItineraryAdapter;
import com.android.weekends.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragItinerary extends Fragment {

    String arr1[] = {"Days 1", "Days 2", "Days 3","Days 4"};
    String arr2[] = {"NJP RAILWAY STATION / IXB (BAGDOGRA AIRPORT) - GANGTOK", "NJP RAILWAY STATION / IXB (BAGDOGRA AIRPORT) - GANGTOK", "NJP RAILWAY STATION / IXB (BAGDOGRA AIRPORT) - GANGTOK","NJP RAILWAY STATION / IXB (BAGDOGRA AIRPORT) - GANGTOK"};
    String arr3[] = {"Arrival at NJP Railway Station / " +
            "Bagdogra Airport. Transfer to Gangtok (5500 ft /125 kms / 04 hrs). " +
            "Evening free on leisure. Over night at Hotel at Gangtok.", "Arrival at NJP Railway Station / Bagdogra Airport. Transfer to Gangtok (5500 ft /125 kms / 04 hrs). Evening free on leisure. Over night at Hotel at Gangtok.", "Arrival at NJP Railway Station / Bagdogra Airport. Transfer to Gangtok (5500 ft /125 kms / 04 hrs). Evening free on leisure. Over night at Hotel at Gangtok.","Arrival at NJP Railway Station / Bagdogra Airport. " +
            "Transfer to Gangtok (5500 ft /125 kms / 04 hrs). Evening free on leisure. Over night at Hotel at Gangtok."};
    public FragItinerary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag__itinerary, container, false);

        FragItineraryAdapter adapter2= new FragItineraryAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView2 = view.findViewById(R.id.recycle_itnitary);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setAdapter(adapter2);

        return view;

    }

}
