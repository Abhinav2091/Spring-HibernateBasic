package com.luv2code.springdemo.annotation.serviceImpl;

import com.luv2code.springdemo.annotation.service.Coach;
import com.luv2code.springdemo.annotation.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("customeBean")
@Scope("prototype")
public class TrackerCoach implements Coach {
    public TrackerCoach(){
        System.out.println("default cont get called before setter injection");

    }
    @Value("${luv2code.name}")
    private String name;
    @Value("${luv2code.age}")
    private int age;

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

    private FortuneService fortuneService;
    // Setter injection in Annotation
    //need not to be setter method can be any method name
    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return getName()+" you should Track 30 Miles in a Day you are just "+getAge();
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.dailyFortune();
    }

    //define init method they cant have argument
    @PostConstruct
    public void doStartupStuff()
    {
        System.out.println("Start init method");
    }
    //define my destroy method
    @PreDestroy //wont get called in case of protype
    public void doCleanupStuff()
    {
        System.out.println("destroy method");
    }
}
