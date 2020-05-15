package com.luv2code.springdemo.noXml.serviceImpl;

import com.luv2code.springdemo.noXml.service.Coach;
import com.luv2code.springdemo.noXml.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
    private FortuneService fortuneService;
    @Value("${luv2code.name}")
    private String name;
    @Value("${luv2code.age}")
    private int age;


    // bean configuration is done in java class
    public SwimCoach(FortuneService fortuneService)
    {
    this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return getName()+" get start to Swim";
    }

    @Override
    public String getDailyFortune() {
        return "You are just "+getAge() +fortuneService.getFortune();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
