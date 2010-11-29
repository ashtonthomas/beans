package com.billy.bob.client.activity.menu;

import com.billy.bob.client.view.partials.BarContextMenu;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class BarContextMenuActivity extends AbstractActivity {
	public BarContextMenu view;
	
	@Inject
	public BarContextMenuActivity(BarContextMenu view){
		this.view = view;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
	}

}
