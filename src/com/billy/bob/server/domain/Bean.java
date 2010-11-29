package com.billy.bob.server.domain;

public class Bean {
	private int id;
	private String name;
	
	public Bean(){}
	
	public Bean(int id, String name){
		this.setId(id);
		this.setName(name);
	}
	
	// Getters
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	// Setters
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
