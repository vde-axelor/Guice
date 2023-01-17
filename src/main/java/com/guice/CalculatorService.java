package com.guice;

import com.google.inject.Inject;

public class CalculatorService {
	@Inject
	private Calculator c;
	
	public int c(int a,int b,String operator) {
		if(operator.equalsIgnoreCase("add")) {
			return c.addition(a, b);
		}
		else if(operator.equalsIgnoreCase("sub")) {
			return c.subtraction(a, b);
		}
		else if(operator.equalsIgnoreCase("div")) {
			return c.division(a, b);
		}
		else{
			return c.multiplication(a, b);
		}
	}
}
