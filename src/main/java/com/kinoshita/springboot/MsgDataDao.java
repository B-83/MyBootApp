package com.kinoshita.springboot;

import java.io.Serializable;
import java.util.List;

import com.kinoshita.springboot.entity.MsgData;

public interface MsgDataDao<T> {

	public List<MsgData> getAll();
	public MsgData findById(long id);
}
