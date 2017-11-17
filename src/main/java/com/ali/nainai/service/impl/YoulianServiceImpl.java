package com.ali.nainai.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.ali.nainai.entity.Youlian;
import com.ali.nainai.exception.ServiceException;
import com.ali.nainai.repository.YoulianRepository;
import com.ali.nainai.service.YoulianService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class YoulianServiceImpl implements YoulianService {
	
	@Resource
	private YoulianRepository youlianRepository;
	
	@Override
	public List<Youlian> findAll() {
		return youlianRepository.findAll();
	}
	
	@Override
	public List<Youlian> findAllVisiable() {
		return youlianRepository.findAllByStatus(0);
	}

	@Override
	public Page<Youlian> findAll(Pageable pageable) {
		return youlianRepository.findAll(pageable);
	}

	@Override
	public Youlian findById(Long id) {
		return youlianRepository.findOne(id);
	}

	@Override
	public void saveOrUpdate(Youlian youlian) {
		if(youlian != null){
			if(youlian.getId() != null){
				Youlian dbYoulian = findById(youlian.getId());
				dbYoulian.setTitle(youlian.getTitle());
				dbYoulian.setUrl(youlian.getUrl());
				dbYoulian.setDescription(youlian.getDescription());
				dbYoulian.setStatus(youlian.getStatus());
				youlianRepository.saveAndFlush(dbYoulian);
			}else{
				youlian.setStatus(0);
				youlianRepository.save(youlian);
			}
		}else{
			throw new ServiceException("保存对象不能为空");
		}
		
	}

	@Override
	public void delete(Long id) {
		youlianRepository.delete(id);
	}

	@Override
	public void changeStatus(Long id) {
		if(id == null){
			throw new ServiceException("ID不能为空");
		}
		Youlian youlian = findById(id);
		youlian.setStatus(youlian.getStatus() == 0?1:0);
		youlianRepository.saveAndFlush(youlian);
	}
}
