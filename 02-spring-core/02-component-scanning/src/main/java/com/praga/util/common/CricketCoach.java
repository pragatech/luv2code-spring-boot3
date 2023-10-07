package com.praga.util.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 mins!!!";
    }
}
