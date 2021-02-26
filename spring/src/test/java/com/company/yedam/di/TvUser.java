package com.company.yedam.di;

public class TvUser {

	public static void main(String[] args) {
		
		BeanFactory factory = new BeanFactory();
		Tv tv = (Tv)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}