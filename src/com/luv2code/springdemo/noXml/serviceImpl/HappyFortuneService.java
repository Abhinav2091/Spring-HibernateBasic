package com.luv2code.springdemo.noXml.serviceImpl;

import com.luv2code.springdemo.noXml.service.FortuneService;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "have a nice Day";
    }
}
