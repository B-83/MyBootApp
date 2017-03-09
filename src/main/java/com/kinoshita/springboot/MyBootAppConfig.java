package com.kinoshita.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBootAppConfig {

	@Bean
	MyDataBean myDataBean() {

		if (true) {
			int a = 1;

		}
		return new MyDataBean();
	}
	
	
	
}
