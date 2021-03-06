package com.ali.nainai.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import com.ali.nainai.entity.Options;
import com.ali.nainai.service.OptionsService;
import org.springframework.stereotype.Service;

import com.ali.nainai.repository.OptionsRepository;

@Service
@Transactional
public class OptionsServiceImpl implements OptionsService {
	
	public final String SITEABOUTMEKEY = "siteAboutMe";
	public final String SITENAMEKEY = "siteName";
	public final String SITEDESCRIPTIONKEY = "siteDescription";
	public final String SITEDOMAINKEY = "siteDomain";
	public final String SITECHANGYANAPPID = "siteChangyanAppId";
	
	@Resource
	private ServletContext servletContext;
	
	@Resource
	private OptionsRepository optionsRepository;

	@Override
	public List<Options> findAll() {
		return optionsRepository.findAll();
	}

	@Override
	public void saveAboutMe(String content) {
		Options about = optionsRepository.findByOptionKey(SITEABOUTMEKEY);
		about.setOptionValue(content);
		optionsRepository.save(about);
		
		servletContext.setAttribute(about.getOptionKey(), about.getOptionValue());
	}
}
