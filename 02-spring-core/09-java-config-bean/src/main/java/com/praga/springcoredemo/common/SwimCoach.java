package com.praga.springcoredemo.common;

import com.praga.springcoredemo.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor:"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim 1000 meters as warm up!";
    }
}
