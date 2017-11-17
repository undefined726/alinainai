package com.ali.nainai.controller.admin;

import com.ali.nainai.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndexController extends BaseController {

	@GetMapping("/admin")
	public String index() {
		return "admin/index";
	}

	@GetMapping("/admin/welcome")
	public String welcome() {
		return "admin/welcome";
	}
}
