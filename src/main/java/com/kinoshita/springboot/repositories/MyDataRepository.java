package com.kinoshita.springboot.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kinoshita.springboot.entity.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

	@Query("SELECT d FROM MyData d ORDER BY d.name")
	List<MyData> findAllOrderByName();
	
	@Query("FROM MyData d WHERE age > :min AND age < :max")
	List<MyData> findByAge(@Param("min")int min, @Param("max")int max);
}
