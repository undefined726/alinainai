package com.ali.nainai.repository;

import java.util.List;

import com.ali.nainai.entity.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>{

	List<Tag> findAllByStatus(Integer status);

	/**
	 * 根据标签名获取
	 * @param tagName
	 * @return
	 */
	Tag findByName(String tagName);

}
