package com.ali.nainai.repository;

import java.util.List;

import com.ali.nainai.entity.Youlian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YoulianRepository extends JpaRepository<Youlian, Long> {

	/**
	 * 查询所有可见
	 * @param status
	 * @return
	 */
	List<Youlian> findAllByStatus(int status);


}
