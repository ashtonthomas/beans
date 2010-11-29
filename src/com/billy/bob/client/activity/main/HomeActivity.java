package com.billy.bob.client.activity.main;

import com.billy.bob.client.event.HeaderNotificationEvent;
import com.billy.bob.client.view.main.foo.HomeView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class HomeActivity extends AbstractActivity {
	private HomeView view;
	private EventBus eventBus;
	
	@Inject
	public HomeActivity(HomeView view){
		this.view = view;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.eventBus = eventBus;
		HeaderNotificationEvent event = new HeaderNotificationEvent("Processing the Home Activity");
		eventBus.fireEvent(event);	
		
		panel.setWidget(view.asWidget());
	}

}
