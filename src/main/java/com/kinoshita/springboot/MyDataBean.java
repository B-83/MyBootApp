package com.kinoshita.springboot;

import org.springframework.beans.factory.annotation.Autowired;

import com.kinoshita.springboot.entity.MyData;
import com.kinoshita.springboot.repositories.MyDataRepository;

public class MyDataBean {

	@Autowired
	MyDataRepository repository;
	
	public String getTableTagById(long id) {
		MyData data = repository.findOne(id);
		String result = "<tr><td>" + data.getName()
			+ "</td><td>" + data.getMail()
			+ "</td><td>" + data.getAge()
			+ "</td><td>" + data.getMemo()
			+ "</td></tr>";
		return result;
	}
}
