package com.guice;

import com.google.inject.ImplementedBy;

@ImplementedBy(DiscountByGpay.class)
public interface Discount {
	double getDiscount();
}
