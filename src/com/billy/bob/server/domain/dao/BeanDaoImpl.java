package com.billy.bob.server.domain.dao;

import com.billy.bob.server.domain.Bean;
import com.billy.bob.server.domain.mapper.BeanMapper;
import com.billy.bob.server.domain.mapper.UserMapper;

public class BeanDaoImpl implements BeanDao{
	private BeanMapper beanMapper;
	
	public void setBeanMapper(BeanMapper beanMapper){
		this.beanMapper = beanMapper;
	}

	@Override
	public Bean getBeanByName(String name) {
		// TODO Auto-generated method stub
		return this.beanMapper.getBeanByName(name);
	}

	@Override
	public int getNumBeans() {
		// TODO Auto-generated method stub
		return this.beanMapper.getNumBeans();
	}

	@Override
	public Bean getBeanById(int id) {
		// TODO Auto-generated method stub
		return this.beanMapper.getBeanById(id);
	}

}
