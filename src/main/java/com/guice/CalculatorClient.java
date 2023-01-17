package com.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CalculatorClient {

	public static void main(String[] args) {
		Injector injector=Guice.createInjector(new CalulatorModule());
		CalculatorService cs=injector.getInstance(CalculatorService.class);
//		Calculator c=injector.getInstance(Calculator.class);
//		System.out.println("Addition: "+c.addition(10, 10));
//		System.out.println("Subtration: "+c.subtraction(20, 10));
//		System.out.println("Multiplication: "+c.multiplication(10, 10));
//		System.out.println("Division: "+c.division(10, 2));
		
		System.out.println("Addition: "+cs.c(10, 10,"add"));
		System.out.println("Subtration: "+cs.c(20, 10,"sub"));
		System.out.println("Multiplication: "+cs.c(10, 5,"mul"));
		System.out.println("Division: "+cs.c(10, 2,"div"));
	}

}
