package com.billy.bob.server.domain.mapper;

import org.mybatis.spring.annotation.Mapper;

import com.billy.bob.server.domain.Bean;

@Mapper("beanMapper")
public interface BeanMapper {
	Bean getBeanByName(String name);
	Bean getBeanById(int id);
	int getNumBeans();
}
