package com.android.weekends.modules.tourdetails.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.weekends.R;
import com.android.weekends.database.AppState;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.login.view.LoginActivity;
import com.android.weekends.modules.payments.view.InitialScreenActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragAboutPlace extends Fragment {


    public FragAboutPlace() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_placce, container, false);

        Button PlaceBook=(Button)view.findViewById(R.id.fragmentAboutPlaceBook);
        PlaceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                if (AppState.getInstance(getContext()).getUserToken() == null)
                {
                     i= new Intent(getContext(),LoginActivity.class);

                }
                else {
                     i= new Intent(getContext(),InitialScreenActivity.class);
                }
                startActivity(i);
            }
        });

        return view;

       // return inflater.inflate(R.layout.fragment_about_placce, container, false);

    }

}
