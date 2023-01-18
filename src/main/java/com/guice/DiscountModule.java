package com.guice;

import com.google.inject.AbstractModule;

public class DiscountModule extends AbstractModule{
	//Explicit Bind
	protected void configure() {
		bind(Discount.class).to(DiscountByCard.class);
	}

}
