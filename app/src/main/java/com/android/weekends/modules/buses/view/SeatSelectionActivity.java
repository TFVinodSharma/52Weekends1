package com.android.weekends.modules.buses.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.buses.adapter.SeatSelectionAdapter;
import com.android.weekends.modules.login.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class SeatSelectionActivity extends BaseActivity implements OnSeatSelected  {
    // public  String[] SeatSelection={"","","","",""};
    private static final int COLUMNS = 5;
    private TextView txtSeatSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__selection);

        Toolbar SeatSelectionToolbar = (Toolbar) findViewById(R.id.seatselectiontoolbar);
        setSupportActionBar(SeatSelectionToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Seat Selection");

        txtSeatSelected = (TextView) findViewById(R.id.txt_seat_selected);
        List<AbstractItem> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            if (i % COLUMNS == 0 || i % COLUMNS == 4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i % COLUMNS == 1 || i % COLUMNS == 3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(manager);

        SeatSelectionAdapter adapter = new SeatSelectionAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onSeatSelected(int count) {

        txtSeatSelected.setText("Book "+count+" seats");
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    public  void gotopayments(View v)
    {
        Intent i= new Intent(this,LoginActivity.class);
        startActivity(i);
    }

}
