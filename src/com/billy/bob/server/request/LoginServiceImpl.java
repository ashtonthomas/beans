package com.billy.bob.server.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.billy.bob.client.model.UserDto;
import com.billy.bob.client.request.LoginService;
import com.billy.bob.server.module.auth.Authorization;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{
    private Authorization authorization;

    
    public void setAuthorization(Authorization authorization){
    	this.authorization = authorization;
    }

	public UserDto authenticate(String email, String password) {
		HttpServletRequest request = GwtRpcDispatcherUtil.getThreadLocalRequest();
		HttpSession session = request.getSession(true);
		UserDto user = this.authorization.authenticate(email, password);		
		session.setAttribute("current_user", user);
		return user;
	}

}
