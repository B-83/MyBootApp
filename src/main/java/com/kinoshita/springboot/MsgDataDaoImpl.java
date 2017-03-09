package com.kinoshita.springboot;

import java.util.List;

import javax.persistence.EntityManager;

import com.kinoshita.springboot.entity.MsgData;

public class MsgDataDaoImpl implements MsgDataDao<MsgData> {

	private EntityManager entityManager;
	
	/**
	 * コンストラクタ
	 */
	public MsgDataDaoImpl() {
		super();
	}
	
	public MsgDataDaoImpl(EntityManager manager) {
		entityManager = manager;
	}
	
	
	/**
	 * オーバーライド
	 */
	@Override
	public List<MsgData> getAll() {
		return entityManager
				.createQuery("FROM MsgData")
				.getResultList();
	}

	@Override
	public MsgData findById(long id) {
		return (MsgData)entityManager
				.createQuery("FROM MsgData WHERE id = " + id)
				.getSingleResult();
	}

}
