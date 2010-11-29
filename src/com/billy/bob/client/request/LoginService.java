package com.billy.bob.client.request;


import com.billy.bob.client.model.UserDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login.rpc")
public interface LoginService extends RemoteService {
	UserDto authenticate(String email, String password);
}
