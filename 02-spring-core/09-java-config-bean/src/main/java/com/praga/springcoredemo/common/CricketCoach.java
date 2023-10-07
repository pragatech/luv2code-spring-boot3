package com.praga.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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
