package com.ali.nainai.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ali.nainai.entity.Tag;
import com.ali.nainai.service.TagService;

import org.springframework.stereotype.Component;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class TagDirective implements TemplateDirectiveModel{

	@Resource
	private TagService tagService;
	
	@Override
	public void execute(Environment environment, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
		
		List<Tag> list = tagService.findAll();
		environment.setVariable("list", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(list));
        if (templateDirectiveBody != null) {
            templateDirectiveBody.render(environment.getOut());
        }
		
	}

}
