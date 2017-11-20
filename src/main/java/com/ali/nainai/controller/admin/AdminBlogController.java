package com.ali.nainai.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import com.ali.nainai.common.JsonResult;
import com.ali.nainai.entity.Category;
import com.ali.nainai.service.BlogService;
import com.ali.nainai.service.CategoryService;
import com.ali.nainai.controller.BaseController;
import com.ali.nainai.entity.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/blog")
public class AdminBlogController extends BaseController{
	
	@Resource
	private BlogService blogService;
	
	@Resource
	private CategoryService categoryService;
	
	@GetMapping("/index")
	public String index(){
		return "admin/blog/index";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public Page<Blog> list() {
		PageRequest pageRequest = getPageRequest();
		Page<Blog> page = blogService.findAll(pageRequest);
		return page;
	}
	
	@GetMapping("/form")
	public String form(@RequestParam(required=false) Long id, ModelMap map){
		List<Category> categories = categoryService.findVisible();
		map.put("categories", categories);
		
		if(id != null){
			Blog blog = blogService.findById(id);
			map.put("blog", blog);
		}
		return "admin/blog/form";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public JsonResult save(Blog blog){
		try {
			blog.setAuthor(getLoginUser());
			blogService.saveOrUpdate(blog);
			return JsonResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@PostMapping("/{id}/change")
	@ResponseBody
	public JsonResult change(@PathVariable Long id,String type){
		try {
			blogService.change(id,type);
			return JsonResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@PostMapping("/{id}/del")
	@ResponseBody
	public JsonResult delete(@PathVariable Long id){
		try {
			blogService.delete(id);
			return JsonResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
	}
}
