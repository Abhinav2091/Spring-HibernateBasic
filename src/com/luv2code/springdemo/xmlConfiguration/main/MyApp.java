package com.luv2code.springdemo.xmlConfiguration.main;

import com.luv2code.springdemo.xmlConfiguration.service.Coach;
import com.luv2code.springdemo.xmlConfiguration.serviceImpl.BaseballCoach;

public class MyApp {
    public static void main(String ar[])
    {
        //create the object
        Coach baseballCoach =new BaseballCoach();
        //use the object
        System.out.println(baseballCoach.getDailyWorkout());
    }
}
