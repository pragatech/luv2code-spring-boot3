package com.praga.springcoredemo.rest;

import com.praga.util.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    DemoController(Coach myCoach){
        this.myCoach = myCoach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}