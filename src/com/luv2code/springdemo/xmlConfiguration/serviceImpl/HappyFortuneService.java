package com.luv2code.springdemo.xmlConfiguration.serviceImpl;

import com.luv2code.springdemo.xmlConfiguration.service.FortuneService;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "have a nice Day";
    }
}
