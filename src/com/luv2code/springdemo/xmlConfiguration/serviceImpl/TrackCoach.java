package com.luv2code.springdemo.xmlConfiguration.serviceImpl;

import com.luv2code.springdemo.xmlConfiguration.service.Coach;
import com.luv2code.springdemo.xmlConfiguration.service.FortuneService;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    public TrackCoach(){}
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Track for 30 min";
    }

    @Override
    public String getDailyFortune() {
        return "Tracker Coach:"+fortuneService.getFortune();
    }

    //add an init method
public void doMyStartUpStuff()
{
    System.out.println("Init start Stuff");
}
    //add a destroy method
    public void doMyCleanUpStuff()
    {
        System.out.println("Destroy Stuff");
    }
}
