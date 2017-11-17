package com.ali.nainai.controller.admin;

import javax.annotation.Resource;

import com.ali.nainai.service.UserService;
import com.ali.nainai.common.JsonResult;
import com.ali.nainai.controller.BaseController;
import com.ali.nainai.entity.User;

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

/**
 * Title: BusinessController
 * Description: 用户管理
 *
 * @author zhangxingrui
 * @date 2017/11/13
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {

	@Resource
	private UserService userService;

	/**
	 * @Title: index
	 * @Description: 用户首页
	 * @author zhangxingrui
	 * @return
	 * @date 2017/11/13 21:57
	 */
	@GetMapping("/index")
	public String index() {
		return "admin/user/index";
	}

	/**
	 * @Title: list
	 * @Description: 用户列表
	 * @author zhangxingrui
	 * @return
	 * @date 2017/11/13 21:57
	 */
	@PostMapping("/list")
	@ResponseBody
	public Page<User> list() {
		PageRequest pageRequest = getPageRequest();
		Page<User> page = userService.findAll(pageRequest);
		return page;
	}

	/**
	 * @Title: form
	 * @Description: 用户表单
	 * @author zhangxingrui
	 * @param id
	 * @param map
	 * @return
	 * @date 2017/11/13 21:57
	 */
	@GetMapping("/form")
	public String form(@RequestParam(required=false) Long id, ModelMap map){
		if(id != null){
			User user = userService.findById(id);
			map.put("user", user);
		}
		return "admin/user/form";
	}
	
	/**
	 * @Title: save
	 * @Description: 添加或修改用户
	 * @author zhangxingrui
	 * @param user
	 * @return 
	 * @date 2017/11/13 21:58
	 */
	@PostMapping("/save")
	@ResponseBody
	public JsonResult save(User user){
		try {
			userService.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok();
	}
	
	/**
	 * @Title: delete
	 * @Description: 删除用户
	 * @author zhangxingrui
	 * @param id
	 * @return 
	 * @date 2017/11/13 21:59
	 */
	@PostMapping("/{id}/del")
	@ResponseBody
	public JsonResult delete(@PathVariable Long id){
		try {
			userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok();
	}

}
