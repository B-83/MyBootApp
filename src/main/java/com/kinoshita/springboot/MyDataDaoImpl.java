package com.kinoshita.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.kinoshita.springboot.entity.MyData;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData> {

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	public MyDataDaoImpl() {
		super();
	}
	
	public MyDataDaoImpl(EntityManager manager) {
		entityManager = manager;
	}
	
	@Override
	public List<MyData> getAll() {
		int offset = 0;		//取り出す位置
		int limit = 2;		//取り出す個数
		
		List<MyData> list = null;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).orderBy(builder.asc(root.get("name")));
		list = (List<MyData>)entityManager
				.createQuery(query)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.getResultList();
		return list;
	}

	@Override
	public MyData findById(long id) {
		return (MyData)entityManager.createQuery("from MyData where id = " + id).getSingleResult();
	}
	
	@Override
	public List<MyData> findByName(String name) {
		return (List<MyData>)entityManager.createQuery("from MyData where name = " + name).getResultList();
	}
	
	@Override
	public List<MyData> find(String fstr) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).where(builder.equal(root.get("name"), fstr));
		List<MyData> list = null;
		list = (List<MyData>)entityManager
				.createQuery(query)
				.getResultList();
		return list;
	}
	
	@Override
	public List<MyData> findByAge(int min, int max) {
		return (List<MyData>)entityManager
				.createNamedQuery("findByAge")
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}
}