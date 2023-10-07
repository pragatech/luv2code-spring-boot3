package com.praga.springcoredemo.rest;

import com.praga.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    private Coach anotherCoach;

    public DemoController(){
        System.out.println("Demo Controller");
    }
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach myCoach,
            @Qualifier("cricketCoach") Coach anotherCoach){
        System.out.println("Demo Controller with coach arg");
        this.myCoach=myCoach;
        this.anotherCoach=anotherCoach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/hello")
    public String hello(){
        return "World!";
    }

    @GetMapping("/check")
    public String check(){
        return "comparing beans: myCoach == anotherCoach, "+ (myCoach == anotherCoach);
    }
}
