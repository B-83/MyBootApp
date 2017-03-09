package com.kinoshita.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kinoshita.springboot.MyTLDialect;

@Configuration
public class ThymeleafConfig {
	
	@Bean
	public MyTLDialect myTLDialect () {
		return new MyTLDialect();
	}

}
