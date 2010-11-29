package com.billy.bob.client.model;

import java.util.HashMap;

public class ClientData {
	private static HashMap clientDataHolder = new HashMap();
	
	public static void add(String key, Object value){
		clientDataHolder.put(key, value);
	}
	
	public static Object get(String key){
		return clientDataHolder.get(key);
	}
	
}
