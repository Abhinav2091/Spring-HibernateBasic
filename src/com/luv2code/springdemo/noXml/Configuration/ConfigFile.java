package com.luv2code.springdemo.noXml.Configuration;

import com.luv2code.springdemo.noXml.service.Coach;
import com.luv2code.springdemo.noXml.service.FortuneService;
import com.luv2code.springdemo.noXml.serviceImpl.HappyFortuneService;
import com.luv2code.springdemo.noXml.serviceImpl.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.luv2code.springdemo.noXml")
@PropertySource("classpath:sport.properties")
public class ConfigFile {

    //we can define bean as well

    //define bean for our happy fortune service
    @Bean
    public FortuneService happyFortuneService()
    {
        return new HappyFortuneService();
    }

    //define bean for swim coach and inject depdency happy fortune service
    @Bean
    public Coach swimCoach()
    {
        return new SwimCoach(happyFortuneService());
    }
}
