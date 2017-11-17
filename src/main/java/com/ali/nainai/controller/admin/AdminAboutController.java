package com.ali.nainai.controller.admin;

import javax.annotation.Resource;

import com.ali.nainai.common.JsonResult;
import com.ali.nainai.service.OptionsService;
import com.ali.nainai.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/about")
public class AdminAboutController extends BaseController{
	
	@Resource
	private OptionsService optionsService;
	
	@GetMapping("/index")
	public String index(){
		return "admin/about/index";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public JsonResult save(
			String content
			){
		try {
			optionsService.saveAboutMe(content);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok();
		
	}
}
