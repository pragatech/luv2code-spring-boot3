package com.praga.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    BaseballCoach(){
        System.out.println("BaseBall coach");
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on batting practiceCricketCoach!";
    }
}
