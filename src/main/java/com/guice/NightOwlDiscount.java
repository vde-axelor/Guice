package com.guice;

public class NightOwlDiscount implements Discountable{
	@Override
	public double getDiscount() {
		return 0.35;
	}

}