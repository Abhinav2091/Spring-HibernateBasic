package com.luv2code.springdemo.xmlConfiguration.main;

import com.luv2code.springdemo.xmlConfiguration.service.Coach;
import com.luv2code.springdemo.xmlConfiguration.serviceImpl.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainAppbeanScope {
    public static void main(String ar[])
    {   // by default the scope is singleton

        //load the config file
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_Scope_applicationContext.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_live_applicationContext.xml");
        //retrive the beain from spring container
        Coach coach = context.getBean("trackcoach", TrackCoach.class);
        Coach coach2 = context.getBean("trackcoach", TrackCoach.class);

        //check the object pointing
        System.out.println(coach==coach2);
        //printout memory location
        System.out.println(coach);
        System.out.println(coach2);

        //close the context
        context.close();
    }
}
