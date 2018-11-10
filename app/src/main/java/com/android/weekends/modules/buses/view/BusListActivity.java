package com.android.weekends.modules.buses.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.weekends.modules.buses.adapter.BusListAdapter;
import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class BusListActivity extends BaseActivity {
    public  String[] BusState={"Uttar Pradesh State Road","Rajasthan State Road","Punjab State Road","UttaraKhand State Road","Madhya Pradesh State Road"};
    public  String[] BusCompany={"Transport Corporation(UPSRTC)","Transport Corporation(RSRTC)","Transport Corporation(PSRTC)","Transport Corporation(UKSRTC)","Transport Corporation(MPSRTC)"};
    public String[] TextStartTime={"2:10","3:15","4:30","4:10","5:00"};
    public  String[] TotalTime={"2:10","2:40","3:10","2:50","2:55"};
    public  String[] EndTime={"4:20","5:55","7:40","7:00","7:55"};
    public String[] BusType={"VOLVO (2+2","VOLVO (2+2","VOLVO (2+2","VOLVO (2+2","VOLVO (2+2"};
    public  String[] Fare={"600","650","550","765","720"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__list);

        Toolbar BusSearchListtoolbar=(Toolbar)findViewById(R.id.buslisttoolbar);
        setSupportActionBar(BusSearchListtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // setTitle("Hotel Search");


        RecyclerView RecyclerBusList=(RecyclerView)findViewById(R.id.recycler_bus_list);
        RecyclerBusList.setLayoutManager(new LinearLayoutManager(this));
        RecyclerBusList.setAdapter(new BusListAdapter(BusState,BusCompany,TextStartTime,TotalTime,EndTime,BusType,Fare));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
