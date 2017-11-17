package com.ali.nainai.repository;

import com.ali.nainai.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionsRepository extends JpaRepository<Options, Long>{

	Options findByOptionKey(String key);
}
