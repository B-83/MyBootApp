package com.kinoshita.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kinoshita.springboot.entity.MyData;
import com.kinoshita.springboot.repositories.MyDataRepository;

@Service
public class MyDataService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	MyDataRepository repository;
	
	// 1ページあたりのエンティティ数
	private static final int PAGE_SIZE = 2;
	
	public Page<MyData> getMyDataInPage(Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE);
		return repository.findAll(pageRequest);
	}
	
	public List<MyData> getAll() {
		return (List<MyData>)entityManager
				.createQuery("FROM MyData")
				.getResultList();
	}
	
	public MyData get(int num) {
		return (MyData)entityManager
				.createQuery("FROM MyData WHERE id = " + num)
				.getSingleResult();
	}
	
	public List<MyData> find(String fstr) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).where(builder.equal(root.get("name"), fstr));
		List<MyData> list = null;
		list = (List<MyData>)entityManager
				.createQuery(query)
				.getResultList();
		return list;
	}	
}
