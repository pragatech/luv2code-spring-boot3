package com.praga.springboot.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("$coach.name")
    private String test;
    @GetMapping("/")
    public String getHello(){
        return "Hello World!";
    }
}
