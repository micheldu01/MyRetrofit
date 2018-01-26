package com.example.michel.myretrofit;

import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by michel on 26/01/2018.
 */

public interface Api {
/*
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();


    String BASE_URL = "https://api.github.com/";

    @GET("users/JakeWharton/following")
    Call<List<Hero>> getHeroes();

*/
    String BASE_URL = "https://api.nytimes.com/";

    @GET("svc/topstories/v2/home.json?api-key=c69e095eadba4c708c5d4ffeb0699a41")
    Call<List<Hero>> getHeroes();

}
