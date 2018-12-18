package com.android.weekends.modules.selectpackage.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.base.response.BaseResponse;
import com.android.weekends.databinding.ActivityDomesticPacakgeAcivityBinding;

import com.android.weekends.modules.selectpackage.adapter.DomesticSelectPackageAdapter;
import com.android.weekends.modules.selectpackage.viewmodel.DomesticPackageViewModel;

public class DomesticPacakgeAcivity extends BaseActivity {

    ActivityDomesticPacakgeAcivityBinding activityDomesticPacakgeAcivityBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDomesticPacakgeAcivityBinding=DataBindingUtil.setContentView(this,R.layout.activity_domestic_pacakge_acivity);


        Toolbar Selectpacakagetoolbar=(Toolbar)findViewById(R.id.domestictoolbar);
        setSupportActionBar(Selectpacakagetoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Domestic Packages");

        showProgressDialogue("Fetching Destinations", "Please Wait ...");
        getdomesticpackage();

    }

    private void getdomesticpackage() {

        DomesticPackageViewModel domesticPackageViewModel = ViewModelProviders.of(this).get(DomesticPackageViewModel.class);

        domesticPackageViewModel.getdomesticpackage().observe(this, domesticPackageResponse -> {

            hideProgressDialgogue();

            if (domesticPackageResponse.getdomesticpackage() != null) {
                DomesticSelectPackageAdapter domesticPackageAdapter = new DomesticSelectPackageAdapter(domesticPackageResponse.getdomesticpackage());
                RecyclerView recyclerViewDPA = findViewById(R.id.domesticrecycler);
                recyclerViewDPA.setHasFixedSize(true);
                recyclerViewDPA.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
                recyclerViewDPA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                recyclerViewDPA.setAdapter(domesticPackageAdapter);
            } else {
                showErrorMessage(domesticPackageResponse.getMessage());
            }

        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
