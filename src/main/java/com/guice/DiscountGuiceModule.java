package com.guice;

import com.google.inject.AbstractModule;

public class DiscountGuiceModule extends AbstractModule{
	@Override
	protected void configure() {
		//explicit bind
		bind(Discountable.class).to(NightOwlDiscount.class);
		
	}
}
