package com.billy.bob.client.application;

import com.billy.bob.client.application.ioc.DesktopInjectorWrapper;
import com.billy.bob.client.application.ioc.InjectorWrapper;
import com.billy.bob.client.exception.UserAlreadyExistsException;
import com.billy.bob.client.model.ClientData;
import com.billy.bob.client.model.UserDto;
import com.billy.bob.client.request.LoginService;
import com.billy.bob.client.request.LoginServiceAsync;
import com.billy.bob.client.request.RegisterService;
import com.billy.bob.client.request.RegisterServiceAsync;
import com.billy.bob.client.view.LoginView;
import com.billy.bob.client.view.widgets.RegisterWidget;
import com.billy.bob.client.view.widgets.RegisterWidgetView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;



public class Beans implements EntryPoint {

	// we are going to use our little injectorWrapper to get everything started for us
	// We will use deferred binding so we can create all our different apps (Desktop & Mobile)
	// see the Gwt_seminar.gwt.xml to see how we switch in MobileInjectorWrapper when on a mobile device
	final private InjectorWrapper injectorWrapper = GWT.create(DesktopInjectorWrapper.class);
	
	private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private final RegisterServiceAsync registerService = GWT.create(RegisterService.class);
	private final LoginView view = GWT.create(LoginView.class);
	private final Button button = new Button("login");
	private final Button registerButton = new Button("register");
	private final RegisterWidgetView registerWidgetView = new RegisterWidgetView();
	private final RegisterWidget registerWidget = new RegisterWidget(registerWidgetView);
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		registerWidget.setAnimationEnabled(true);
		ButtonSubmitHandler submitHandler = new ButtonSubmitHandler();
		RegisterButtonHandler registerHandler = new RegisterButtonHandler();
		SubmitRegisterButtonHandler submitRegisterHandler = new SubmitRegisterButtonHandler();
		registerWidgetView.getRegisterButton().addClickHandler(submitRegisterHandler);

		button.addClickHandler(submitHandler);
		registerButton.addClickHandler(registerHandler);
		view.getSubmitBox().add(button);
		view.getRegisterBox().add(registerButton);
		view.getUsernameBox().setText("billy.bob@email.com");
		view.getPasswordBox().setText("password");
		view.getUsernameBox().addKeyUpHandler(submitHandler);
		view.getPasswordBox().addKeyUpHandler(submitHandler);
		view.getUsernameBox().setFocus(true);
		view.getUsernameBox().selectAll();
		
		RootLayoutPanel.get().add(view.asWidget());
		
		
	}
	
	class SubmitRegisterButtonHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			registerWidgetView.getRegisterButton().setText("Please Wait...");
			registerWidgetView.getRegisterButton().setEnabled(false);
			if(!registerWidgetView.getPasswordBox().getText().equals(registerWidgetView.getPasswordConfirmBox().getText())){
				registerWidgetView.getMessage().setText("Passwords do not match");
				registerWidgetView.getRegisterButton().setText("Register");
				registerWidgetView.getRegisterButton().setEnabled(true);
			}else if(registerWidgetView.getEmailBox().getText().isEmpty()){
				registerWidgetView.getMessage().setText("Email is empty");
				registerWidgetView.getRegisterButton().setText("Register");
				registerWidgetView.getRegisterButton().setEnabled(true);
			}else if(registerWidgetView.getPasswordBox().getText().isEmpty()){
				registerWidgetView.getMessage().setText("Password can't be empty");
				registerWidgetView.getRegisterButton().setText("Register");
				registerWidgetView.getRegisterButton().setEnabled(true);
			}else{
				registerWidgetView.getMessage().setText("Sending data to the server");
				String email = registerWidgetView.getEmailBox().getText();
				String password = registerWidgetView.getPasswordBox().getText();
				register(email, password);
			}
		}
	}
	
	class RegisterButtonHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			registerButton.setEnabled(false);
			button.setEnabled(false);
			
			registerWidget.addCloseHandler(new CloseHandler<PopupPanel>(){
				public void onClose(CloseEvent<PopupPanel> event) {
					registerButton.setEnabled(true);
					button.setEnabled(true);
				}
				
			});
			
			
			registerWidget.center();
		}
		
	}
	
	class ButtonSubmitHandler implements ClickHandler, KeyUpHandler {
		public void onClick(ClickEvent event){
			button.setEnabled(false);
			button.setText("Checking...");
			authenticate();
		}
		public void onKeyUp(KeyUpEvent event){
			if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
				button.setEnabled(false);
				button.setText("Checking...");
				authenticate();
			}
		}
	}
	
	private void authenticate(){
		loginService.authenticate(view.getUsernameBox().getText(), view.getPasswordBox().getText(), new AsyncCallback<UserDto>(){
			public void onFailure(Throwable caught){
				
			}
			public void onSuccess(UserDto result){
				if(result!=null){
					ClientData.add("current_user", result);
					loadApp();
				}else{
					button.setText("Nope, try again");
					button.setEnabled(true);
				}
			}
		});
	}
	
	private void register(String email, String password){
		registerService.register(email, password, new AsyncCallback<UserDto>(){
			public void onFailure(Throwable caught){
				// TODO need to check for types of exceptions and handle accordingly
				if(caught instanceof UserAlreadyExistsException){
					registerWidgetView.getMessage().setText(((UserAlreadyExistsException)caught).getSymbol());
					registerWidgetView.getEmailBox().setText("");
					registerWidgetView.getRegisterButton().setText("Register");
					registerWidgetView.getRegisterButton().setEnabled(true);
				}else{
					registerWidgetView.getMessage().setText("An unknown error occured");
				}
				
			}
			public void onSuccess(UserDto result){
				if(result!=null){
					registerWidget.clearWidget();
					registerWidget.hide();
					ClientData.add("current_user", result);
					loadApp();
				}else{
					registerWidgetView.getMessage().setText("Sorry something went wrong. TODO");
				}
			}
		});
	}
	
	public void loadApp(){
		/* use our injectorWrapper to get the appropriate injector and then to use
		 * that to get our platform specific application */
		injectorWrapper.getInjector().getBeansApp().run();
	}
}
