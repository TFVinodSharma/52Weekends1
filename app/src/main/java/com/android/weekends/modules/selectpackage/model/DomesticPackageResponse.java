package com.android.weekends.modules.selectpackage.model;

import com.android.weekends.base.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DomesticPackageResponse extends BaseResponse implements Serializable {

    @SerializedName("contents")

    private ArrayList<PackageDetails> packageDetails;

    public ArrayList getdomesticpackage() {
        return packageDetails;
    }

    public void setdomesticpackage(ArrayList domesticPackageRequests) {
        this.packageDetails = domesticPackageRequests;
    }

}
