package com.ali.nainai.controller.front;

import javax.annotation.Resource;

import com.ali.nainai.service.BlogService;
import com.ali.nainai.utils.StrKit;
import com.ali.nainai.entity.Blog;
import com.ali.nainai.lucene.SearcherKit;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	
	@Resource
	private BlogService blogService;
	
	@Resource
	private SearcherKit searcherKit;

	@RequestMapping("/s")
	public String index(
			@RequestParam String keyword,
			@RequestParam(required = false,defaultValue="1") Integer p,
			ModelMap map 
			){
		if(StrKit.isBlank(keyword)){
			return "redirect:/";
		}
		map.put("keyWord", keyword);
		Page<Blog> page = searcherKit.search(p, 10, keyword);
		map.put("page", page);
		return "front/search/index";
	}
}
