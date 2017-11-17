package com.ali.nainai.config;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.ali.nainai.directive.CategoryDirective;
import com.ali.nainai.directive.TagDirective;
import com.ali.nainai.directive.YoulianDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ali.nainai.directive.BlogDirective;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;
    
    @Resource
    private CategoryDirective categoryDirective;

    @Resource
    private BlogDirective blogDirective;

    @Resource
    private TagDirective tagDirective;

    @Resource
    private YoulianDirective youlianDirective;
    
    @PostConstruct
    public void setSharedVariable() {
    	try {
			configuration.setSharedVariable("categoryList", categoryDirective);
			configuration.setSharedVariable("blogList", blogDirective);
			configuration.setSharedVariable("tagList", tagDirective);
			configuration.setSharedVariable("youlianList", youlianDirective);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
