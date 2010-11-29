package com.billy.bob.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class BeanDto implements IsSerializable{
	private String name;
	
	public BeanDto(){}
	
	public BeanDto(String name){
		this.setName(name);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
