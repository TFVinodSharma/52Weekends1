package com.android.weekends.modules.tourdetails.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.weekends.modules.tourdetails.adapter.FragStayInfoAdapter;
import com.android.weekends.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragStayInfo extends Fragment {

    String arr1[] = {"Hotel Inorri/Sikkim continental/Iris Inn"};
    String arr2[] = {"Gangtok"};
    String arr3[] = {"Sikkim"};
    String arr4[] = {"2"};
    String arr5[] = {"1.Free WIFI \n2.Room Service \n"};
    public FragStayInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_frag_stay_info, container, false);
        FragStayInfoAdapter adapter11= new FragStayInfoAdapter(arr1,arr2,arr3,arr4,arr5);
        RecyclerView recyclerView11 = view.findViewById(R.id.recycle_stay_info);
        recyclerView11.setHasFixedSize(true);
        recyclerView11.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView11.setAdapter(adapter11);

       return view;
    }

}
