package com.billy.bob.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class RegisterWidgetView extends Composite {

	private static RegisterWidgetViewUiBinder uiBinder = GWT
			.create(RegisterWidgetViewUiBinder.class);

	interface RegisterWidgetViewUiBinder extends
			UiBinder<Widget, RegisterWidgetView> {
	}
	
	@UiField Label message;
	@UiField TextBox email;
	@UiField PasswordTextBox password;
	@UiField PasswordTextBox password_confirm;
	@UiField Button register_button;
	@UiField Button cancel_button;

	public RegisterWidgetView() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public RegisterWidgetView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public Label getMessage(){
		return message;
	}
	
	public TextBox getEmailBox(){
		return email;
	}
	
	public PasswordTextBox getPasswordBox(){
		return password;
	}
	
	public PasswordTextBox getPasswordConfirmBox(){
		return password_confirm;
	}
	
	public Button getRegisterButton(){
		return register_button;
	}
	
	public Button getCancelButton(){
		return cancel_button;
	}


}
