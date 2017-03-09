package com.kinoshita.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kinoshita.springboot.entity.MsgData;

public interface MsgDataRepository extends JpaRepository<MsgData, Long> {

}
