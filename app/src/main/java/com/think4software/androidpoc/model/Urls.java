package com.think4software.androidpoc.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Void on 04/05/2017.
 */

public class Urls {

    @Expose
    private String raw;
    @Expose
    private String full;
    @Expose
    private String regular;
    @Expose
    private String small;
    @Expose
    private String thumb;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
