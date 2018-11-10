package com.android.weekends.modules.login.model;

import com.android.weekends.base.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse extends BaseResponse implements Serializable {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
