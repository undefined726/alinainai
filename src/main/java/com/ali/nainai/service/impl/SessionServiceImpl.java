package com.ali.nainai.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.ali.nainai.entity.Session;
import com.ali.nainai.repository.SessionRepository;
import com.ali.nainai.service.SessionService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
	
	@Resource
	private SessionRepository sessionRepository;

	@Override
	public Session findBySessionId(String sessionId) {
		return sessionRepository.findBySessionId(sessionId);
	}

}
