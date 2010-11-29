package com.billy.bob.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}
	
	@UiField SimplePanel submit;
	@UiField SimplePanel register;
	@UiField TextBox username;
	@UiField PasswordTextBox password;

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public LoginView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public SimplePanel getSubmitBox(){
		return submit;
	}
	
	public SimplePanel getRegisterBox(){
		return register;
	}
	
	public TextBox getUsernameBox(){
		return username;
	}
	
	public PasswordTextBox getPasswordBox(){
		return password;
	}

}
