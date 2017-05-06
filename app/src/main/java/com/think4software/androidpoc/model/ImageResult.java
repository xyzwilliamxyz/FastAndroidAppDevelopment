package com.think4software.androidpoc.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Void on 04/05/2017.
 */

public class ImageResult {

    @Expose
    private Urls urls;

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }
}
