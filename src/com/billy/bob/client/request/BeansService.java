package com.billy.bob.client.request;

import java.util.ArrayList;

import com.billy.bob.client.model.BeanDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("beans.rpc")
public interface BeansService extends RemoteService {
	ArrayList<BeanDto> getAllBeans();
}
