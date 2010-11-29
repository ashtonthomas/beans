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
import com.google.gwt.user.client.ui.Widget;

public class FooContextMenu extends Composite {

	private static FooContextMenuUiBinder uiBinder = GWT
			.create(FooContextMenuUiBinder.class);

	interface FooContextMenuUiBinder extends
			UiBinder<Widget, FooContextMenu> {
	}

	public FooContextMenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public FooContextMenu(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
