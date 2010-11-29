package com.billy.bob.client.application.ioc;

import com.billy.bob.client.application.BillyBobApp;
import com.google.gwt.inject.client.Ginjector;

// Interface for that forces or "extending" injectors (who are interfaces)
// to return an AcrintaFitnessApp
public interface AppInjector extends Ginjector {
	// not too exciting. just setting up our interface
	BillyBobApp getBeansApp();
}
