package com.billy.bob.client.activity.mapper;

import com.billy.bob.client.activity.main.BeanActivity;
import com.billy.bob.client.activity.main.HomeActivity;
import com.billy.bob.client.activity.main.SearchActivity;
import com.billy.bob.client.place.BeanBarPlace;
import com.billy.bob.client.place.HomeFooPlace;
import com.billy.bob.client.place.SearchPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;


/* This is the Main Mapper that tells the ActivityManager
 * which Activity to load given a particular Place. */
public class MainActivityMapper implements ActivityMapper {
	private HomeActivity homeActivity;
	private BeanActivity beanActivity;
	private SearchActivity searchActivity;
	
	@Inject 
	public MainActivityMapper(HomeActivity homeActivity, BeanActivity beanActivity, SearchActivity searchActivity){
		this.homeActivity = homeActivity;
		this.beanActivity = beanActivity;
		this.searchActivity = searchActivity;
		
	}

	public Activity getActivity(Place place) {
		
		if(place instanceof HomeFooPlace){
			return homeActivity;
		}else if(place instanceof BeanBarPlace){
			return beanActivity;
		}else if(place instanceof SearchPlace){
			return searchActivity;
		}
		else{
			// no good...
			return null;
		}
	}
	

}
