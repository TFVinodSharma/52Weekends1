package com.android.weekends.modules.login.model;

import com.android.weekends.base.request.BaseRequest;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginRequest extends BaseRequest implements Serializable {


    @SerializedName("email")
    private String email;


    @SerializedName("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
