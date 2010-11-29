package com.billy.bob.client.application;


import com.billy.bob.client.activity.mapper.ContextMenuActivityMapper;
import com.billy.bob.client.activity.mapper.MainActivityMapper;
import com.billy.bob.client.event.HeaderNotificationEvent;
import com.billy.bob.client.model.ClientData;
import com.billy.bob.client.model.UserDto;
import com.billy.bob.client.place.AppPlaceHistoryMapper;
import com.billy.bob.client.place.HomeFooPlace;
import com.billy.bob.client.view.DesktopShell;
import com.billy.bob.client.view.partials.MainMenuView;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;


public class DesktopApp extends BillyBobApp {
	private final DesktopShell shell;
	private final EventBus eventBus;
	private final PlaceController placeController;
	private final MainActivityMapper mainActivityMapper;
	private final AppPlaceHistoryMapper appPlaceHistoryMapper;
	private final MainMenuView mainMenuView;
	private final ContextMenuActivityMapper contextMenuActivityMapper;
	
	private Place defaultPlace = new HomeFooPlace();
	
	@Inject
	public DesktopApp(DesktopShell shell, EventBus eventBus, PlaceController placeController, 
			MainActivityMapper mainActivityMapper, AppPlaceHistoryMapper appPlaceHistoryMapper, MainMenuView mainMenuView,
			ContextMenuActivityMapper contextMenuActivityMapper){
		this.shell = shell;
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.mainActivityMapper = mainActivityMapper;
		this.appPlaceHistoryMapper = appPlaceHistoryMapper;
		this.mainMenuView = mainMenuView;
		this.contextMenuActivityMapper = contextMenuActivityMapper;
		
		// tell the event but that the shell can handle alert events
		this.eventBus.addHandler(HeaderNotificationEvent.TYPE, shell);

		
	}
	
	public void run(){
		/* Add handlers, setup activities */
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				Window.alert("Hey, something went wrong: " + e.getMessage());
				// we could log this if we were using logging...
				
			}
		});
		
		CachingActivityMapper cached = new CachingActivityMapper(mainActivityMapper);
		final ActivityManager mainActivityManager = new ActivityManager(cached, eventBus);
		
		mainActivityManager.setDisplay(shell.getContent());
		
		CachingActivityMapper cachedContextMenu = new CachingActivityMapper(contextMenuActivityMapper);
		final ActivityManager contextMenuActivityManager = new ActivityManager(cachedContextMenu, eventBus);
		contextMenuActivityManager.setDisplay(shell.getContextMenu());
		
		// Set up UI
		shell.getMainMenu().setWidget(mainMenuView);
		
		// Set up some navigation
		// TO-DO
		
		//Hyperlink link = new Hyperlink("Home", "home");
		//shell.getHomeLink().add(link);

		shell.getUserPanel().clear();
		UserDto user = ((UserDto) ClientData.get("current_user"));
		HTML stuff = new HTML("Welcome: "+user.getEmail());
		shell.getUserPanel().add(stuff);
		
		// History management 
		AppPlaceHistoryMapper historyMapper = appPlaceHistoryMapper;
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		
		// add out UiBinder shell to the Root Panel (the main html document thingy)
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(shell);
		historyHandler.handleCurrentHistory();
		
	}
	


}
