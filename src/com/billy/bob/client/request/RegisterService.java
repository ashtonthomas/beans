package com.billy.bob.client.request;

import com.billy.bob.client.exception.UserAlreadyExistsException;
import com.billy.bob.client.model.UserDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("register.rpc")
public interface RegisterService extends RemoteService {
	UserDto register(String email, String password) throws UserAlreadyExistsException;
}
