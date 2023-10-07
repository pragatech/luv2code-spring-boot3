package com.praga.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    TennisCoach(){
        System.out.println("Tennis Coach");
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on back-hand volley!";
    }
}
