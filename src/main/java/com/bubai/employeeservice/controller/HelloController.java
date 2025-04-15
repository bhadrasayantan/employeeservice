package com.bubai.employeeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.TimeZone;

@RestController
@RequestMapping("/v1/hello")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/greetings")
    public String getGreetings(){
        return "Hello User";
    }
    @GetMapping("/greetings/localized")
    public String getCustomizedGreetings(){
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        logger.info("Current time is {}", now);
        logger.info("TimeZone is {}", TimeZone.getDefault().getDisplayName());
        String greetings = "Hello User";
        if(hour < 12){
            greetings = "Good Morning User";
        }
        if(hour>12 && hour<18){
            greetings = "Good Afternoon User";
        }
        if(hour>18 && hour<24){
            greetings = "Good Evening User";
        }
        return greetings;
    }
}
