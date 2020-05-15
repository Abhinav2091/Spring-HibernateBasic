package com.luv2code.springdemo.noXml.main;

import com.luv2code.springdemo.noXml.Configuration.ConfigFile;
import com.luv2code.springdemo.noXml.service.Coach;
import com.luv2code.springdemo.noXml.serviceImpl.SwimCoach;
import com.luv2code.springdemo.noXml.serviceImpl.TrackerCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.w3c.dom.ls.LSOutput;

public class SpringNoXmlMainClass {
    public static void main(String ar[]) {
        //read the spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);

        //get the bean
        Coach coach = context.getBean("trackerCoach", TrackerCoach.class);
        Coach swimCoach = context.getBean("swimCoach", SwimCoach.class);

        //call the method
        System.out.println(coach.getDailyWorkout());
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());

        //close the context
        context.close();

    }
}
