package com.billy.bob.server.domain;

import java.util.Date;
import java.sql.Timestamp;

public class User {
	private int id;
	private String email;
	private String password_hash;
	
	public User(){}
	
	public User(int id, String email, String password){
		this.setId(id);
		this.setEmail(email);
		this.setPasswordHash(password);
	}
	
	// Getters
	
	public int getId(){
		return id;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPasswordHash(){
		return password_hash;
	}
	
	// Setters
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPasswordHash(String password_hash){
		this.password_hash = password_hash;
	}

		
}
