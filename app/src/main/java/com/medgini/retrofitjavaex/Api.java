package com.medgini.retrofitjavaex;

import com.medgini.retrofitjavaex.pojo.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String Base_url = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
