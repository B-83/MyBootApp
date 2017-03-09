package com.kinoshita.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kinoshita.springboot.entity.MyDataMongo;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, String> {

	public List<MyDataMongo> findByName(String s);
}
