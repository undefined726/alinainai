package net.sppan;

import java.util.List;

import javax.annotation.Resource;

import com.ali.nainai.AlinainaiBlogApplication;
import com.ali.nainai.entity.Blog;
import com.ali.nainai.service.BlogService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AlinainaiBlogApplication.class)
public class SPPanBlogApplicationTests {

	@Resource
	private BlogService blogService;
	
	@Test
	public void contextLoads() {
		List<Blog> list = blogService.findHotN(5);
		System.out.println(list);
	}

}
