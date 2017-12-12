package com.ali.nainai.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: TestController
 * Description: 测试控制器
 *
 * @author zhangxingrui
 * @date 2017/11/17
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping("/index")
	public String index(ModelMap map) {
		map.put("host", "127.0.0.1:8083");
		return "/test/index";
	}

	@GetMapping("/login")
	public String login(ModelMap map) {
//		map.put("host", "127.0.0.1:8083");
		return "/admin/login2";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello world!!!";
	}

}
