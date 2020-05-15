package com.luv2code.springdemo.annotation.main;

import com.luv2code.springdemo.annotation.service.Coach;
//import com.luv2code.springdemo.annotation.serviceImpl.TrackerCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationMainApp {
    public static void main(String ar[])
    {
        //read spring config file
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
        //get the bean from spring container
        //constructor dependency Injection
        //Coach trackerCoach =context.getBean("tennisCoach", Coach.class);
        //setter depency Injection and custome bean
        Coach trackerCoach =context.getBean("customeBean", Coach.class);
        Coach trackerCoach2 =context.getBean("customeBean", Coach.class);
        //field Injection mostely used and easy concep know as Reflection
        //Coach trackerCoach =context.getBean("footballCoach", Coach.class);

        //call the method from bean
        System.out.println(trackerCoach.getDailyWorkout());
        System.out.println(trackerCoach.getDailyFortune());

        //scope check by default is single ton

        System.out.println(trackerCoach==trackerCoach2);

        //close the context
        context.close();
    }
}
