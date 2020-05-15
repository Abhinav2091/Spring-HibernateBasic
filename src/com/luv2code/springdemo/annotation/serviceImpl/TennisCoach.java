package com.luv2code.springdemo.annotation.serviceImpl;

import com.luv2code.springdemo.annotation.service.Coach;
import com.luv2code.springdemo.annotation.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;


//    //Constructor injection
    @Autowired
    public TennisCoach(@Qualifier("sadFortuneService") FortuneService fortuneService)
    {
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Tennise for 90 Days";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.dailyFortune();
    }
}
