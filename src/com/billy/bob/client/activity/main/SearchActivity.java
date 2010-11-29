package com.billy.bob.client.activity.main;

import com.billy.bob.client.view.main.foo.SearchView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.search.client.ExpandMode;
import com.google.gwt.search.client.ImageSearch;
import com.google.gwt.search.client.ResultSetSize;
import com.google.gwt.search.client.SearchControl;
import com.google.gwt.search.client.SearchControlOptions;
import com.google.gwt.search.client.WebSearch;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;

public class SearchActivity extends AbstractActivity{
	private SearchView view;
	
	@Inject
	public SearchActivity(SearchView view){
		this.view = view;
	}
	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		SearchControlOptions options = new SearchControlOptions();
	    WebSearch webSearch = new WebSearch();
	    webSearch.setResultSetSize(ResultSetSize.LARGE);
	    options.add(webSearch);
	    ImageSearch imageSearch = new ImageSearch();
	    options.add(imageSearch, ExpandMode.OPEN);
	    
	    final SearchControl control = new SearchControl(options);
	    //control.execute("treehouse");
	   
    
		view.getContent().clear();
		view.getContent().add(control);
		panel.setWidget(view);
	}

}
