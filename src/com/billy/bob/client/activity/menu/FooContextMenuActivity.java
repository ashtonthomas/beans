package com.billy.bob.client.activity.menu;

import com.billy.bob.client.view.partials.FooContextMenu;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class FooContextMenuActivity extends AbstractActivity {
	public FooContextMenu view;
	
	@Inject
	public FooContextMenuActivity(FooContextMenu view){
		this.view = view;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
	}

}
