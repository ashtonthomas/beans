package com.billy.bob.server.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.billy.bob.client.exception.UserAlreadyExistsException;
import com.billy.bob.client.model.UserDto;
import com.billy.bob.client.request.RegisterService;
import com.billy.bob.server.module.auth.Authorization;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegisterServiceImpl extends RemoteServiceServlet implements RegisterService{
    private Authorization authorization;

    
    public void setAuthorization(Authorization authorization){
    	this.authorization = authorization;
    }
	
	public UserDto register(String email, String password) throws UserAlreadyExistsException {
		HttpServletRequest request = GwtRpcDispatcherUtil.getThreadLocalRequest();
		HttpSession session = request.getSession(true);
		UserDto user = this.authorization.register(email, password);
		session.setAttribute("current_user", user);
		return user;
	}
}
