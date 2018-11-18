package com.android.weekends.modules.destination.model;

import com.android.weekends.base.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DestinationResponse extends BaseResponse implements Serializable {

    @SerializedName("contents")
    private ArrayList<DestinationModel> destinations;

    public ArrayList getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList destinations) {
        this.destinations = destinations;
    }

}

