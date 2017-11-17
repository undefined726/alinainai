package com.ali.nainai.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ali.nainai.common.JsonResult;
import com.ali.nainai.entity.Session;
import com.ali.nainai.service.UserService;
import com.ali.nainai.utils.IpKit;
import com.ali.nainai.controller.BaseController;
import com.ali.nainai.utils.CookieKit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: LoginController
 * Description: 后台登录
 *
 * @author zhangxingrui
 * @date 2017/11/10
 * @version 1.0
 */
@Controller
public class LoginController extends BaseController{
	
	@Resource
	private UserService userService;
	
	/**
	 * @Title: login
	 * @Description:  跳转登录页面
	 * @author zhangxingrui
	 * @return
	 * @date 2017/11/10 11:06
	 */
	@GetMapping("/login")
	public String login(){
		return "admin/login";
	}

	/**
	 * @Title: updatePWD
	 * @Description:  跳转到修改密码的页面
	 * @author zhangxingrui
	 * @return
	 * @date 2017/11/10 11:30
	 */
	@GetMapping("/update_form")
	public String updatePWD(){
		return "admin/update_form";
	}

	/**
	 * @Title: logout
	 * @Description:  注销用户
	 * @author zhangxingrui
	 * @return
	 * @date 2017/11/10 11:30
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		String sessionId = CookieKit.getSessionIdFromCookie(request, response);
		userService.logout(sessionId);
		CookieKit.removeSessionIdFromCookie(response);
		return "redirect:/admin";
	}

	/**
	 * @Title: login
	 * @Description:  执行登录
	 * @author zhangxingrui
	 * @param username
	 * @param password
	 * @param keepLogin
	 * @return
	 * @date 2017/11/10 11:26
	 */
	@ResponseBody
	@PostMapping("/login")
	public JsonResult login(HttpServletRequest request, HttpServletResponse response,
			String username, String password, @RequestParam(required = false) Boolean keepLogin){
		try {
			String ip = IpKit.getRealIp(request);
			//登录系统
			Session session = userService.login(username,password,keepLogin,ip);
			//把sessionID写入cookie
			CookieKit.setSessionId2Cookie(response, session.getSessionId(), ip, true);
			//重定向到后台管理首页
			return JsonResult.ok().set("returnUrl", "/admin");
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	
	/**
	 * @Title: updatePwd
	 * @Description:  修改密码
	 * @author zhangxingrui
	 * @param oldpassword
	 * @param password1
	 * @param password2
	 * @return
	 * @date 2017/11/10 11:32
	 */
	@PostMapping("/updatePwd")
	@ResponseBody
	public JsonResult updatePwd(HttpServletRequest request, HttpServletResponse response,
			String oldpassword, String password1, String password2){
		try {
			userService.updatePassword(getLoginUser(), oldpassword, password1, password2);
			CookieKit.removeSessionIdFromCookie(response);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok();
	}
}
