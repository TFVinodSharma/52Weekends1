package com.android.weekends.model.request;

import com.android.weekends.base.request.BaseRequest;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignupRequest extends BaseRequest implements Serializable {

    @SerializedName("user_name")
    private String fullName;

    @SerializedName("email")
    private String email;

    @SerializedName("title")
    private String title;

    @SerializedName("phone")
    private String phone;


    @SerializedName("password")
    private String password;

    @SerializedName("countryId")
    private String countryId;

    @SerializedName("city")
    private String city;

    @SerializedName("address")
    private String address;

    @SerializedName("pincode")
    private String pincode;

    public SignupRequest(String fullName, String email, String title, String phone, String password, String countryId, String city, String address, String pincode) {
        this.fullName = fullName;
        this.email = email;
        this.title = title;
        this.phone = phone;
        this.password = password;
        this.countryId = countryId;
        this.city = city;
        this.address = address;
        this.pincode = pincode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
