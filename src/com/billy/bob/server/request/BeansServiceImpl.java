package com.billy.bob.server.request;

import java.util.ArrayList;

import com.billy.bob.client.model.BeanDto;
import com.billy.bob.client.request.BeansService;
import com.billy.bob.server.domain.Bean;
import com.billy.bob.server.domain.dao.BeanDao;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BeansServiceImpl extends RemoteServiceServlet implements BeansService {
	private BeanDao beanDao;
	
	public void setBeanDao(BeanDao beanDao){
		this.beanDao = beanDao;
	}
	
	public ArrayList<BeanDto> getAllBeans(){
		ArrayList<BeanDto> beans = new ArrayList<BeanDto>();
		for(int i=0;i<this.beanDao.getNumBeans();i++){
			Bean bean= this.beanDao.getBeanById(i+1);
			BeanDto beanDto = new BeanDto(bean.getName());
			beans.add(beanDto);
			
		}
		return beans;
	}
}
