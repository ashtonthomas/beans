package com.billy.bob.client.request;

import java.util.ArrayList;

import com.billy.bob.client.model.BeanDto;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BeansServiceAsync {
	void getAllBeans(AsyncCallback<ArrayList<BeanDto>> callback);
}
