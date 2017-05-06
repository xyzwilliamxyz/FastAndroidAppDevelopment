package com.think4software.androidpoc.dao;

import com.think4software.androidpoc.model.Counter;

import org.androidannotations.annotations.EBean;

import java.sql.SQLException;


/**
 * Created by Void on 28/04/2017.
 */
@EBean
public class CounterDao {

    public Counter getCounter() throws SQLException {

        return Counter.find(Counter.class, null, null).get(0);
    }

    public void saveCounter(Counter counter) throws SQLException {

        counter.save();
    }
}
