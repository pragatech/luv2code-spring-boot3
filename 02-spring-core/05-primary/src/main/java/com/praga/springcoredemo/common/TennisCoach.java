package com.praga.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on back-hand volley!";
    }
}
