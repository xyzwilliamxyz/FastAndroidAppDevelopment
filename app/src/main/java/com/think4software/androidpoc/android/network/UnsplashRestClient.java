package com.think4software.androidpoc.android.network;

import com.think4software.androidpoc.model.ImageResult;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Void on 03/05/2017.
 */


public interface UnsplashRestClient {

    @GET("photos/random?client_id=6d0c93c41310c43cd563d14c69b80bc4a44682e7f93b6a01580d9782a68714bc")
    Call<ImageResult> getRandomImage();
}
