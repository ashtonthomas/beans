package com.billy.bob.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;

public class RegisterWidget extends PopupPanel {
	private RegisterWidgetView view;
	
	public RegisterWidget(RegisterWidgetView view){
		// PopupPanel's constructor takes 'auto-hide' as its boolean parameter.
	      // If this is set, the panel closes itself automatically when the user
	      // clicks outside of it.
	      super(false);
	      
	      this.view = view;
	      view.getRegisterButton().setText("Register");
	      view.getCancelButton().setText("Cancel");
	      
	      view.getCancelButton().addClickHandler(new ClickHandler(){
	    	  public void onClick(ClickEvent event){
	    		  closeRegister();
	    	  }
	      });

	      // PopupPanel is a SimplePanel, so you have to set it's widget property to
	      // whatever you want its contents to be.
	      setWidget(view);
	}
	
	public void clearWidget(){
		view.getPasswordBox().setText("");
		view.getPasswordConfirmBox().setText("");
		view.getEmailBox().setText("");
	}
	
	public void closeRegister(){
		this.hide();
	}
}
