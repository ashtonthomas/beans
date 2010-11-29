package com.billy.bob.client.activity.main;

import java.util.ArrayList;

import com.billy.bob.client.event.HeaderNotificationEvent;
import com.billy.bob.client.model.BeanDto;
import com.billy.bob.client.request.BeansServiceAsync;
import com.billy.bob.client.view.main.bar.BeanView;
import com.billy.bob.client.view.main.foo.HomeView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;

public class BeanActivity extends AbstractActivity {
	private BeanView view;
	private EventBus eventBus;
	private BeansServiceAsync beansService;
	private ArrayList<BeanDto> beans;
	
	@Inject
	public BeanActivity(BeanView view, BeansServiceAsync beansService){
		this.view = view;
		this.beansService = beansService;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.eventBus = eventBus;
		HeaderNotificationEvent event = new HeaderNotificationEvent("Processing the BEAN Activity!");
		eventBus.fireEvent(event);	
		final Button button = new Button("Get Beans");
		
		
		
		class GetBeansHandler implements ClickHandler {
			
			public void onClick(ClickEvent event) {
				
				beansService.getAllBeans(new AsyncCallback<ArrayList<BeanDto>>(){

					public void onFailure(Throwable caught) {
						button.setText("something went wrong..");
					}

					public void onSuccess(ArrayList<BeanDto> result) {
						view.getContent().clear();
						String listOfBeans = "";
						for(BeanDto bean : result){
							listOfBeans = listOfBeans +"<br/> "+bean.getName();
						}
						view.getContent().setWidget(new HTML(listOfBeans));
					}
					
				});
			}
			
		}
		
		
		GetBeansHandler handler = new GetBeansHandler();
		button.addClickHandler(handler);
		view.getContent().clear();
		view.getContent().setWidget(button);
		panel.setWidget(view.asWidget());
	}
	

	
	

}
