package com.android.weekends.base.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseResponse  implements Serializable {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
