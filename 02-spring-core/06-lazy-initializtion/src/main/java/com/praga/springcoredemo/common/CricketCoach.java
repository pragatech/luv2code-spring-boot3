package com.praga.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    CricketCoach(){
        System.out.println("Cricket coach");
    }
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 mins ;-)";
    }
}
