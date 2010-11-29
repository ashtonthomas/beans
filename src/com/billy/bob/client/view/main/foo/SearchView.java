package com.billy.bob.client.view.main.foo;

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

public class SearchView extends Composite {

	private static SearchViewUiBinder uiBinder = GWT
			.create(SearchViewUiBinder.class);

	interface SearchViewUiBinder extends UiBinder<Widget, SearchView> {
	}

	public SearchView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField SimplePanel content;

	public SearchView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public SimplePanel getContent(){
		return content;
	}

}
