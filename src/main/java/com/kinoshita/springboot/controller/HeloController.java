package com.kinoshita.springboot.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kinoshita.springboot.entity.MyData;
import com.kinoshita.springboot.entity.MyDataMongo;
import com.kinoshita.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {
	
	// Beanオブジェクトに関連付ける
//	@Autowired
//	MyDataRepository repository;
//	
//	@Autowired
//	MyDataService service;
//	
//	@Autowired
//	MyDataBean myDataBean;
	
	@Autowired
	MyDataMongoRepository  repository;
	
	/**
	 * 全取得・表示
	 * @param mydata
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyDataMongoのサンプルです。");
		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form (
			@RequestParam("name") String name,
			@RequestParam("memo") String memo,
			ModelAndView mav) {
		MyDataMongo mydata = new MyDataMongo(name, memo);
		repository.save(mydata);
		return new ModelAndView("redirect:/");
	}
	
	
	
	/**
	 * find
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView find(ModelAndView mav) {
		mav.setViewName("find");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyDataのサンプルです。");
		mav.addObject("value", "");
		List<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("find") String param, ModelAndView mav) {
		mav.setViewName("find");
		
		if (param == "") {
			mav = new ModelAndView("redirect:/find");
		} else {
			mav.addObject("title", "Find result");
			mav.addObject("msg", "「" + param + "」の検索結果");
			mav.addObject("value", param);
			List<MyDataMongo> list = repository.findByName(param);
			mav.addObject("datalist", list);
		}
		
		return mav;
	}
	
	
	/**
	 * id一致検索
	 * @param id
	 * @param mav
	 * @return
	 */
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ModelAndView indexById(@PathVariable long id, ModelAndView mav) {
//		mav.setViewName("pickup");
//		mav.addObject("title", "Pickup Page");
//		String table = "<table>"
//				+ myDataBean.getTableTagById(id)
//				+ "</table>";
//		mav.addObject("msg", "pickup data id = " + id);
//		mav.addObject("data", table);
//		return mav;
//	}
	

	/**
	 * ページネーション
	 * @param num
	 * @param mav
	 * @return
	 */
//	@RequestMapping(value = "/page/{num}", method = RequestMethod.GET)
//	public ModelAndView page(@PathVariable Integer num, ModelAndView mav) {
//		Page<MyData> page = service.getMyDataInPage(num);
//		mav.setViewName("index");
//		mav.addObject("title", "Find Page");
//		mav.addObject("msg", "MyDataのサンプルです。");
//		mav.addObject("pagenumber", num);
//		mav.addObject("datalist", page);
//		return mav;
//	}
	
	/**
	 * 初期(ダミー)データ
	 */
	@PostConstruct
	public void init() {
		MyData d1 = new MyData();
		d1.setName("tuyano");
		d1.setAge(123);
		d1.setMail("syoda@tuyano.com");
		d1.setMemo("000000000");
//		repository.save(d1);
		
		MyData d2 = new MyData();
		d2.setName("hanako");
		d2.setAge(15);
		d2.setMail("hanako@flower");
		d2.setMemo("111111111");
//		repository.save(d2);
		
		MyData d3 = new MyData();
		d3.setName("sachiko");
		d3.setAge(37);
		d3.setMail("sachiko@happy");
		d3.setMemo("222222222");
//		repository.save(d3);
	}
	
	/**
	 * test
	 * @param mav
	 * @return
	 */
	@RequestMapping("/test")
	public ModelAndView test(ModelAndView mav) {
		mav.setViewName("test");
		return mav;
	}

}