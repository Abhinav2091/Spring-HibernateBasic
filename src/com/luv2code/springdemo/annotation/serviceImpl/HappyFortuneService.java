package com.luv2code.springdemo.annotation.serviceImpl;

import com.luv2code.springdemo.annotation.service.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String dailyFortune() {
        return "Work hard For Future";
    }
}
