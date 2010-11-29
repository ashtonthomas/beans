package com.billy.bob.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class HeaderNotificationEvent extends GwtEvent<HeaderNotificationHandler> {
	public static final Type<HeaderNotificationHandler> TYPE = new Type<HeaderNotificationHandler>();
	private final String message;
	
	public HeaderNotificationEvent(String message){
		this.message = message;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<HeaderNotificationHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(HeaderNotificationHandler handler) {
		handler.onHeaderNotification(this);
	}
	
	public String getMessage(){
		return message;
	}

}
