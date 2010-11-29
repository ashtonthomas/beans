package com.billy.bob.client.application.ioc;

import com.billy.bob.client.application.DesktopApp;
import com.google.gwt.inject.client.GinModules;

// Okay so we are just going to define an Injector interface 
// that uses the @annotation to point to the particular "AbstractGinModule" class

@GinModules(value = {AppInjectorModule.class})
public interface DesktopInjector extends AppInjector {
	// notice we are returning a "DesktopApp" which extends AcrintaFitnessApp
	// This will tell Gin to create a DesktopApp instead of a MobileApp or TabletApp
	DesktopApp getBeansApp();
}
