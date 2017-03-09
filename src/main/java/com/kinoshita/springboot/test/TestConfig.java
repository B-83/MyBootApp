package com.kinoshita.springboot.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	MyDialect myDialect() {
		return new MyDialect();
	}
}
