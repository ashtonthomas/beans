package com.billy.bob.client.view;

import com.billy.bob.client.event.HeaderNotificationEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;


public class DesktopShell extends AppShell {
	private static DesktopShellUiBinder uiBinder = GWT
			.create(DesktopShellUiBinder.class);
	
	interface DesktopShellUiBinder extends UiBinder<Widget, DesktopShell> {}

	
	@UiField SimplePanel content;
	@UiField SimplePanel main_menu;
	@UiField SimplePanel context_menu;
	@UiField SimplePanel user_panel;
		
	public DesktopShell(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public SimplePanel getUserPanel(){
		return user_panel;
	}
	
	public SimplePanel getContent(){
		return content;
	}
	
	public SimplePanel getMainMenu(){
		return main_menu;
	}
	
	public SimplePanel getContextMenu(){
		return context_menu;
	}

	@Override
	public void onHeaderNotification(HeaderNotificationEvent event) {
		addHeaderNotification(event.getMessage());
	}
	
	// would need to check and clear any previous unfired timers
	// but I am just going to use this hack for now..
	native void addHeaderNotification(String s)/*-{
		$doc.getElementById("alert").innerHTML=s;		
		setTimeout('$doc.getElementById("alert").innerHTML=""', 3000);
				
		
	}-*/;

}