package com.luv2code.springdemo.noXml.serviceImpl;

import com.luv2code.springdemo.noXml.service.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackerCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "You are getting good with Time in Teraking";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
