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

public class BarContextMenu extends Composite {

	private static BarContextMenuUiBinder uiBinder = GWT
			.create(BarContextMenuUiBinder.class);

	interface BarContextMenuUiBinder extends
			UiBinder<Widget, BarContextMenu> {
	}

	public BarContextMenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public BarContextMenu(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
