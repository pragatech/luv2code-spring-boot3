package com.praga.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    TrackCoach(){
        System.out.println("Track Coach");
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
