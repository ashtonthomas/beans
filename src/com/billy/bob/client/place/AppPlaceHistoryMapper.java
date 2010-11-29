package com.billy.bob.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.google.inject.Inject;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */

//@WithTokenizers( { })
public class AppPlaceHistoryMapper implements PlaceHistoryMapper{

	private HomeFooPlace homePlace;
	private BeanBarPlace beanPlace;
	private SearchPlace searchPlace;

	@Inject
	public AppPlaceHistoryMapper(HomeFooPlace homePlace, BeanBarPlace beanPlace, SearchPlace searchPlace){
		
		this.homePlace = homePlace;
		this.beanPlace = beanPlace;
		this.searchPlace = searchPlace;
		
	}

	@Override
	public Place getPlace(String token) {
		
		if(token.startsWith("home")){
			return homePlace;
		}else if(token.startsWith("beans")){
			return beanPlace;
		}else if(token.startsWith("search")){
			return searchPlace;
		}
		else{
			return null;
		}
	}

	@Override
	public String getToken(Place place) {
		if(place instanceof AppPlace){
			return ((AppPlace) place).getToken();
		}
		
		return null;
	}
	
}
