package com.company.yedam.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		Tv tv = factory.getBean(Tv.class); //name(=id), class 타입 모두 가능
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
