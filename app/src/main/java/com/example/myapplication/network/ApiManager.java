package com.example.myapplication.network;

import android.telecom.Call;

import com.example.myapplication.model.Wheather;

import java.util.List;

public interface ApiManager {
    public static String BASE_URL = "http://dataservice.accuweather.com";

    @GET("/forecasts/v1/daily/12day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    default Call<List<Wheather>> gethour() ;





}
