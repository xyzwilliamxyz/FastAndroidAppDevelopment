package com.think4software.androidpoc.service;

import com.think4software.androidpoc.android.network.UnsplashRestClient;
import com.think4software.androidpoc.model.ImageResult;

import org.androidannotations.annotations.EBean;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Void on 05/05/2017.
 */

@EBean
public class UnsplashService {

    UnsplashRestClient unsplashRestClient;

    Retrofit retrofit;

    public UnsplashService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        unsplashRestClient = retrofit.create(UnsplashRestClient.class);
    }

    public ImageResult fetchRandomImage() {
        Call<ImageResult> imageResultCall = unsplashRestClient.getRandomImage();

        try {
            return imageResultCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
