package com.billy.bob.client.view;

import com.billy.bob.client.event.HeaderNotificationHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public abstract class AppShell extends Composite implements HeaderNotificationHandler{

	public SimplePanel getContent(){
		return null;
	}
	
	public SimplePanel getAlert(){
		return null;
	}
	
}
