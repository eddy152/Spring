package com.company.yedam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.yedam.di.AppleSpeaker;
import com.company.yedam.di.LgTV;
import com.company.yedam.di.SamsungTV;
import com.company.yedam.di.SonySpeaker;
import com.company.yedam.di.Speaker;
import com.company.yedam.di.Tv;

//@Configuration// 자바 기반의 설정 파일 <> xml
public class AppConfig {
	@Bean
	public Speaker speaker() {
		return new AppleSpeaker();
	}
	@Bean
	public Tv tvSvc() {
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker());
		return tv;
	}
}
