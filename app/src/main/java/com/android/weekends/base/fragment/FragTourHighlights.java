package com.android.weekends.base.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.weekends.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragTourHighlights extends Fragment {


    public FragTourHighlights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_tour_highlights, container, false);
    }

}
