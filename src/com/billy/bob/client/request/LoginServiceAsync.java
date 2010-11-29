package com.billy.bob.client.request;

import com.billy.bob.client.model.UserDto;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	void authenticate(String email, String password, AsyncCallback<UserDto> callback);
}
