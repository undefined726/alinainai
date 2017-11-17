package com.ali.nainai;

import javax.annotation.Resource;

import com.ali.nainai.config.intercepter.ViewsCountIntercepter;
import com.ali.nainai.config.intercepter.CommonIntercepter;
import com.ali.nainai.config.intercepter.LoginIntercepter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.ali.nainai.mapper")
public class AlinainaiBlogApplication extends WebMvcConfigurerAdapter {
	
	@Resource
    private CommonIntercepter commonInterceptor;

	@Resource
	private LoginIntercepter loginIntercepter;

	@Resource
	private ViewsCountIntercepter viewsCountIntercepter;

	public static void main(String[] args) {
		SpringApplication.run(AlinainaiBlogApplication.class, args);
	}
	
	  /**
     * add interceptors
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        // 公共拦截器
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
        // 后台登录拦截器
        registry.addInterceptor(loginIntercepter).addPathPatterns("/admin/**").excludePathPatterns("/admin/login");
        // 博客页面访问拦截
        registry.addInterceptor(viewsCountIntercepter).addPathPatterns("/b/view/**");
    }
}
