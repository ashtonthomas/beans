package com.billy.bob.client.activity.mapper;

import com.billy.bob.client.activity.menu.BarContextMenuActivity;
import com.billy.bob.client.activity.menu.FooContextMenuActivity;
import com.billy.bob.client.place.BarPlace;
import com.billy.bob.client.place.FooPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

public class ContextMenuActivityMapper implements ActivityMapper {
	private FooContextMenuActivity fooContextMenuActivity;
	private BarContextMenuActivity barContextMenuActivity;

	
	@Inject
	public ContextMenuActivityMapper(FooContextMenuActivity fooContextMenuActivity, BarContextMenuActivity barContextMenuActivity){
		
		this.fooContextMenuActivity = fooContextMenuActivity;
		this.barContextMenuActivity = barContextMenuActivity;
		
	}
	

	public Activity getActivity(Place place) {
		if(place instanceof FooPlace){
			return fooContextMenuActivity;
		}else if(place instanceof BarPlace){
			return barContextMenuActivity;
		}else{
			System.out.println("Context Menu does not exist for: "+place.getClass());
			return null;
		}
	}
	

}
