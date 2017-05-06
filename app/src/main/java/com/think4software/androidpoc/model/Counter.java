package com.think4software.androidpoc.model;

import com.orm.SugarRecord;

/**
 * Created by Void on 28/04/2017.
 */
public class Counter extends SugarRecord<Counter> {

    private Integer value = 0;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void increaseCounter() {
        this.value++;
    }
}
