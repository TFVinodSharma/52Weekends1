package com.android.weekends.modules.selectpackage.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.base.listener.OnItemSelectionListener;
import com.android.weekends.modules.selectpackage.adapter.InternationalSelectPackageAdapter;
import com.android.weekends.modules.selectpackage.model.PackageDetails;
import com.android.weekends.modules.selectpackage.viewmodel.InternationalPackageViewModel;
import com.android.weekends.modules.tourdetails.view.PackageDetailsActivity;

public class InternationalPackageActivity extends BaseActivity implements OnItemSelectionListener<PackageDetails> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international_package);

        Toolbar Selectpacakagetoolbar=(Toolbar)findViewById(R.id.internationaltoolbar);
        setSupportActionBar(Selectpacakagetoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("International Packages");

        showProgressDialogue("Fetching Destinations", "Please Wait ...");
        getinternationalpackage();

    }


    private void getinternationalpackage() {

         InternationalPackageViewModel internationalPackageViewModel = ViewModelProviders.of(this).get(InternationalPackageViewModel.class);
         internationalPackageViewModel.getinternationalpackage().observe(this, internationalPackageResponse -> {

            hideProgressDialgogue();

            if (internationalPackageResponse.getinternationalpackage() != null) {
                InternationalSelectPackageAdapter internationalSelectPackageAdapter = new InternationalSelectPackageAdapter(internationalPackageResponse.getinternationalpackage());
                RecyclerView recyclerViewIPA = findViewById(R.id.internationalrecyclerview);
                recyclerViewIPA.setHasFixedSize(true);
                recyclerViewIPA.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
                recyclerViewIPA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                recyclerViewIPA.setAdapter(internationalSelectPackageAdapter);
                internationalSelectPackageAdapter.setOnItemSelectionListener(this);
            } else {
                showErrorMessage(internationalPackageResponse.getMessage());
            }

        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onItemSelected(PackageDetails internationalPackage) {
        Intent i=new Intent(this,PackageDetailsActivity.class);
        i.putExtra(PackageDetailsActivity.PACKAGE_DETAILS,internationalPackage);
        startActivity(i);
    }
}
