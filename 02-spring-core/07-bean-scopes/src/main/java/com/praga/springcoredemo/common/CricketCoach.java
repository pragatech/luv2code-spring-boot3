package com.praga.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    CricketCoach(){
        System.out.println("Cricket coach");
    }
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 mins ;-)";
    }
}
