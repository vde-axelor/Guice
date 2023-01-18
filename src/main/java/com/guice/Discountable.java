package com.guice;

import com.google.inject.ImplementedBy;
//use of implementedby method
@ImplementedBy(EarlyBirdDiscount.class)
public interface Discountable {
	double getDiscount();
}
