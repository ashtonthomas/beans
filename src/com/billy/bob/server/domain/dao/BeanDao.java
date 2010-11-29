package com.billy.bob.server.domain.dao;

import com.billy.bob.server.domain.Bean;

public interface BeanDao {
	public Bean getBeanByName(String name);
	public Bean getBeanById(int id);
	public int getNumBeans();
}
