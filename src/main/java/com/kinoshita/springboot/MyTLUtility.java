package com.kinoshita.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTLUtility {

	private static final Logger log = LoggerFactory.getLogger(MyTLUtility.class);
	
	public String hello(String name) {
		return "Hello, <b>" + name + "!</b>";
	}
	
	public String prevUrl(int num) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■start■■■■■■■■■■■■■■■■■■■■■■■");
		log.error("aaa", num);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■end■■■■■■■■■■■■■■■■■■■■■■■");
		return "1";
	}
	
	public String nextUrl(int num) {
		return "/page/" + "2";
	}
}
