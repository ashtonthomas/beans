package com.billy.bob.client.view.partials;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class MainMenuView extends Composite {

	private static MainMenuViewUiBinder uiBinder = GWT
			.create(MainMenuViewUiBinder.class);

	interface MainMenuViewUiBinder extends UiBinder<Widget, MainMenuView> {
	}

	public MainMenuView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public MainMenuView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
