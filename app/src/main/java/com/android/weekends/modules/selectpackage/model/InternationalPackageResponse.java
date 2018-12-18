package com.android.weekends.modules.selectpackage.model;

import com.android.weekends.base.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class InternationalPackageResponse extends BaseResponse implements Serializable {

    @SerializedName("contents")

    private ArrayList<PackageDetails> internationalPackageRequests;

    public ArrayList getinternationalpackage() {
        return internationalPackageRequests;
    }

    public void setdomesticpackage(ArrayList internationalPackageRequests) {
        this.internationalPackageRequests = internationalPackageRequests;
    }

}
