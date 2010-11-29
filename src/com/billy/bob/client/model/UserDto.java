package com.billy.bob.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserDto implements IsSerializable {
	private String email;
	
	public UserDto(){}
	
	public UserDto(String email){
		this.setEmail(email);
	}

	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}
