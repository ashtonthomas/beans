package com.billy.bob.client.style;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resource extends ClientBundle {	
	public static final Resource INSTANCE = GWT.create(Resource.class);
	
	@Source("css/main.css")
	Style mainStyle();
	
	@Source("images/arrow.gif")
	ImageResource arrow();
	
	@Source("images/bg.jpg")
	ImageResource bg();
	
	@Source("images/bullet.gif")
	ImageResource bullet();
	
	@Source("images/clock.gif")
	ImageResource clock();
	
	@Source("images/comment.gif")
	ImageResource comment();
	
	@Source("images/firefox-gray.jpg")
	ImageResource firefoxGray();
	
	@Source("images/footerbg.jpg")
	ImageResource footerbg();
	
	@Source("images/header.jpg")
	ImageResource header();
	
	@Source("images/menubg.jpg")
	ImageResource menubg();
	
	@Source("images/page.gif")
	ImageResource page();
	
	@Source("images/quote.gif")
	ImageResource quote();

	
	public interface Style extends CssResource {
		
	}
}
