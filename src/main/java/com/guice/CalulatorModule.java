package com.guice;

import com.google.inject.AbstractModule;

public class CalulatorModule extends AbstractModule{
	@Override
	protected void configure() {
		bind(Calculator.class);
	}

}
