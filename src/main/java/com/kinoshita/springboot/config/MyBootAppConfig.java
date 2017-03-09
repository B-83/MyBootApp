package com.kinoshita.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kinoshita.springboot.MyDataBean;
import com.kinoshita.springboot.MyTLDialect;

@Configuration
public class MyBootAppConfig {

	@Bean
	MyDataBean myDataBean() {
		return new MyDataBean();
	}

	@Bean
	public MyTLDialect myTLDialect () {
		return new MyTLDialect();
	}
}
