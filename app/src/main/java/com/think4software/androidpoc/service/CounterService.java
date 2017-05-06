package com.think4software.androidpoc.service;

import com.think4software.androidpoc.dao.CounterDao;
import com.think4software.androidpoc.model.Counter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;


/**
 * Created by Void on 28/04/2017.
 */

@EBean
public class CounterService {

    @Bean
    CounterDao counterDao;

    public void saveCounter(Counter counter) {

        try {
            counterDao.saveCounter(counter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Counter getCounter() {

        try {
            return counterDao.getCounter();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
