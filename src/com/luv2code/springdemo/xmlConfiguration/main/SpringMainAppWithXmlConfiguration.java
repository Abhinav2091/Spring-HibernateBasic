package com.luv2code.springdemo.xmlConfiguration.main;

import com.luv2code.springdemo.xmlConfiguration.service.Coach;
import com.luv2code.springdemo.xmlConfiguration.serviceImpl.HockeyCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainAppWithXmlConfiguration {
    public static void main(String ar[])
    {
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        //retrieve bean from  spring container u can use bean name as per xml file
        Coach theCoach= context.getBean("hockeyCoach",Coach.class);
        //used this to call the email and team getter method
        HockeyCoach hockeyCoach= context.getBean("hockeyCoach", HockeyCoach.class);

        //call method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(hockeyCoach.getEmail());
        System.out.println(hockeyCoach.getTeam());
        System.out.println(hockeyCoach.getName());
        System.out.println(hockeyCoach.getAge());


        //close the context
        context.close();
    }
}
