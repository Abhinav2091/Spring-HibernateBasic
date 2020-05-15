package com.luv2code.springdemo.annotation.serviceImpl;

import com.luv2code.springdemo.annotation.service.Coach;
import com.luv2code.springdemo.annotation.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Your Legs need to be strong for this";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.dailyFortune();
    }
}
