package com.kinoshita.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTLUtility {

	private static final Logger log = LoggerFactory.getLogger(MyTLUtility.class);
	
	public String hello(String name) {
		return "Hello, <b>" + name + "!</b>";
	}
	
	/**
	 * 前ページのリンク
	 * @param num
	 * @return
	 */
	public String prevUrl(int num) {
		return "/page/" + (num > 1 ? num -1 : 1);
	}
	
	/**
	 * 次ページのリンク
	 * @param num
	 * @return
	 */
	public String nextUrl(int num) {
		return "/page/" + (num + 1);
	}
}
