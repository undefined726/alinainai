package com.ali.nainai.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.ali.nainai.entity.Category;
import com.ali.nainai.exception.ServiceException;
import com.ali.nainai.service.BlogService;
import com.ali.nainai.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ali.nainai.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CategoryRepository categoryRepository;

	@Resource
	private BlogService blogService;

	@Override
	public List<Category> findVisible() {
		return categoryRepository.findByStatus(0);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public void saveOrUpdate(Category category) {
		if(category.getId() != null){
			Category dbcCategory = findById(category.getId());
			dbcCategory.setName(category.getName());
			dbcCategory.setStatus(category.getStatus());
			categoryRepository.save(dbcCategory);
		}else{
			category.setCount(0);
			categoryRepository.saveAndFlush(category);
		}
	}

	@Override
	public void delete(Long id) {
		Long count = blogService.getBlogCountByCategory(findById(id));
		if (count != null && count > 0) {
			throw new ServiceException("分类下面包含博客，不能删除");
		}else{
			categoryRepository.delete(id);
		}
	}

	@Override
	public void changeStatus(Long id) {
		if(id == null){
			throw new ServiceException("ID不能为空");
		}
		Category category = findById(id);
		category.setStatus(category.getStatus() == 0?1:0);
		categoryRepository.saveAndFlush(category);
	}

	@Override
	public void countCategoryHasBlog() {
		List<Category> list = categoryRepository.findAll();
		for (Category category : list) {
			Long count = blogService.getBlogCountByCategory(category);
			category.setCount(count.intValue());
		}
		categoryRepository.save(list);
	}

}
