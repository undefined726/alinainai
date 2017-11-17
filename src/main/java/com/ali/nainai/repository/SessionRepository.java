package com.ali.nainai.repository;

import com.ali.nainai.entity.Session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

	Session findBySessionId(String sessionId);

}
