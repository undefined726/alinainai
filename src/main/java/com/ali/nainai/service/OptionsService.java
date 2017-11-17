package com.ali.nainai.service;

import java.util.List;

import com.ali.nainai.entity.Options;


public interface OptionsService {

	List<Options> findAll();

	/**
	 * 设置关于我
	 * @param content
	 */
	void saveAboutMe(String content);
}
