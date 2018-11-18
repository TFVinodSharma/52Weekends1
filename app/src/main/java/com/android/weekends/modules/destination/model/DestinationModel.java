package com.android.weekends.modules.destination.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DestinationModel  implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("uid")
    private String uid;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("getting_there")
    private String gettingThere;

    @SerializedName("train")
    private String train;

    @SerializedName("road")
    private String road;

    @SerializedName("air")
    private String air;

    @SerializedName("visit_time")
    private String visit_time;

    @SerializedName("visit_do")
    private String visit_do;

    @SerializedName("acco")
    private String acco;

    @SerializedName("food")
    private String food;

    @SerializedName("imp_facts")
    private String imp_facts;

    @SerializedName("places_nearby")
    private String places_nearby;

    @SerializedName("near_places")
    private String near_places;

    @SerializedName("main_image_title")
    private String main_image;

    @SerializedName("acco_image_1_title")
    private String acco_image_1_title;

    @SerializedName("acco_image_2_title")
    private String acco_image_2_title;

    @SerializedName("food_image_1_title")
    private String food_image_1_title;

    @SerializedName("food_image_2_title")
    private String food_image_2_title;

    @SerializedName("other_image_1_title")
    private String other_image_1_title;

    @SerializedName("other_image_2_title")
    private String other_image_2_title;

    @SerializedName("other_image_3_title")
    private String other_image_3_title;

    @SerializedName("other_image_4_title")
    private String other_image_4_title;

    @SerializedName("other_image_5_title")
    private String other_image_5_title;

    @SerializedName("other_image_6_title")
    private String other_image_6_title;

    @SerializedName("acco_image_1")
    private String acco_image_1;

    @SerializedName("acco_image_2")
    private String acco_image_2;

    @SerializedName("food_image_1")
    private String food_image_1;

    @SerializedName("food_image_2")
    private String food_image_2;

    @SerializedName("other_image_1")
    private String other_image_1;

    @SerializedName("other_image_2")
    private String other_image_2;

    @SerializedName("other_image_3")
    private String other_image_3;

    @SerializedName("other_image_4")
    private String other_image_4;

    @SerializedName("other_image_5")
    private String other_image_5;

    @SerializedName("other_image_6")
    private String other_image_6;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;

    @SerializedName("country")
    private String country;

    @SerializedName("featured")
    private String featured;

    @SerializedName("status")
    private String status;

    @SerializedName("highlighted")
    private String highlighted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGettingThere() {
        return gettingThere;
    }

    public void setGettingThere(String gettingThere) {
        this.gettingThere = gettingThere;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }

    public String getVisit_do() {
        return visit_do;
    }

    public void setVisit_do(String visit_do) {
        this.visit_do = visit_do;
    }

    public String getAcco() {
        return acco;
    }

    public void setAcco(String acco) {
        this.acco = acco;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getImp_facts() {
        return imp_facts;
    }

    public void setImp_facts(String imp_facts) {
        this.imp_facts = imp_facts;
    }

    public String getPlaces_nearby() {
        return places_nearby;
    }

    public void setPlaces_nearby(String places_nearby) {
        this.places_nearby = places_nearby;
    }

    public String getNear_places() {
        return near_places;
    }

    public void setNear_places(String near_places) {
        this.near_places = near_places;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    public String getAcco_image_1_title() {
        return acco_image_1_title;
    }

    public void setAcco_image_1_title(String acco_image_1_title) {
        this.acco_image_1_title = acco_image_1_title;
    }

    public String getAcco_image_2_title() {
        return acco_image_2_title;
    }

    public void setAcco_image_2_title(String acco_image_2_title) {
        this.acco_image_2_title = acco_image_2_title;
    }

    public String getFood_image_1_title() {
        return food_image_1_title;
    }

    public void setFood_image_1_title(String food_image_1_title) {
        this.food_image_1_title = food_image_1_title;
    }

    public String getFood_image_2_title() {
        return food_image_2_title;
    }

    public void setFood_image_2_title(String food_image_2_title) {
        this.food_image_2_title = food_image_2_title;
    }

    public String getOther_image_1_title() {
        return other_image_1_title;
    }

    public void setOther_image_1_title(String other_image_1_title) {
        this.other_image_1_title = other_image_1_title;
    }

    public String getOther_image_2_title() {
        return other_image_2_title;
    }

    public void setOther_image_2_title(String other_image_2_title) {
        this.other_image_2_title = other_image_2_title;
    }

    public String getOther_image_3_title() {
        return other_image_3_title;
    }

    public void setOther_image_3_title(String other_image_3_title) {
        this.other_image_3_title = other_image_3_title;
    }

    public String getOther_image_4_title() {
        return other_image_4_title;
    }

    public void setOther_image_4_title(String other_image_4_title) {
        this.other_image_4_title = other_image_4_title;
    }

    public String getOther_image_5_title() {
        return other_image_5_title;
    }

    public void setOther_image_5_title(String other_image_5_title) {
        this.other_image_5_title = other_image_5_title;
    }

    public String getOther_image_6_title() {
        return other_image_6_title;
    }

    public void setOther_image_6_title(String other_image_6_title) {
        this.other_image_6_title = other_image_6_title;
    }

    public String getAcco_image_1() {
        return acco_image_1;
    }

    public void setAcco_image_1(String acco_image_1) {
        this.acco_image_1 = acco_image_1;
    }

    public String getAcco_image_2() {
        return acco_image_2;
    }

    public void setAcco_image_2(String acco_image_2) {
        this.acco_image_2 = acco_image_2;
    }

    public String getFood_image_1() {
        return food_image_1;
    }

    public void setFood_image_1(String food_image_1) {
        this.food_image_1 = food_image_1;
    }

    public String getFood_image_2() {
        return food_image_2;
    }

    public void setFood_image_2(String food_image_2) {
        this.food_image_2 = food_image_2;
    }

    public String getOther_image_1() {
        return other_image_1;
    }

    public void setOther_image_1(String other_image_1) {
        this.other_image_1 = other_image_1;
    }

    public String getOther_image_2() {
        return other_image_2;
    }

    public void setOther_image_2(String other_image_2) {
        this.other_image_2 = other_image_2;
    }

    public String getOther_image_3() {
        return other_image_3;
    }

    public void setOther_image_3(String other_image_3) {
        this.other_image_3 = other_image_3;
    }

    public String getOther_image_4() {
        return other_image_4;
    }

    public void setOther_image_4(String other_image_4) {
        this.other_image_4 = other_image_4;
    }

    public String getOther_image_5() {
        return other_image_5;
    }

    public void setOther_image_5(String other_image_5) {
        this.other_image_5 = other_image_5;
    }

    public String getOther_image_6() {
        return other_image_6;
    }

    public void setOther_image_6(String other_image_6) {
        this.other_image_6 = other_image_6;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(String highlighted) {
        this.highlighted = highlighted;
    }
}
