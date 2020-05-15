package com.luv2code.springdemo.xmlConfiguration.serviceImpl;

import com.luv2code.springdemo.xmlConfiguration.service.Coach;
import com.luv2code.springdemo.xmlConfiguration.service.FortuneService;

public class HockeyCoach implements Coach {
    private FortuneService fortuneService;

    private String email;
    private String team;

    private String name;
    private int age;

    public HockeyCoach(){
        System.out.println("Spring use this default const for setter injection");
    }
    @Override
    public String getDailyWorkout() {
        return "spend 30 min practice in Hockey Court";
    }

    @Override
    public String getDailyFortune() {
        return "Hockey coach:"+fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setEmail(String email) {
        this.email = email;
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
