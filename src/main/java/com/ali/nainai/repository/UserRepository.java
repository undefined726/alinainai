package com.ali.nainai.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ali.nainai.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	Page<User> findAllByOrderByCreateAtDesc(Pageable pageable);

}
