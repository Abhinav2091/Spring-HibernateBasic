package com.luv2code.springdemo.xmlConfiguration.serviceImpl;

import com.luv2code.springdemo.xmlConfiguration.service.Coach;
import com.luv2code.springdemo.xmlConfiguration.service.FortuneService;

public class BaseballCoach implements Coach
{
	//define a private field for the dependency
	private FortuneService fortuneService;

	public BaseballCoach(){};

	//define a constructor for dependnecy
	public BaseballCoach(FortuneService thefortuneService)
	{
		this.fortuneService=thefortuneService;
	}

@Override
public String getDailyWorkout()
{
	return "spend 30 min practice in Base ball Court";
}

	@Override
	public String getDailyFortune() {
		//use fortune to get a fortune
		return fortuneService.getFortune();
	}

}
