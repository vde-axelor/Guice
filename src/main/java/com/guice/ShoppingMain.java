package com.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ShoppingMain {

	public static void main(String[] args) {
		Injector guice=Guice.createInjector();
		ShoppingBillProcess process=guice.getInstance(ShoppingBillProcess.class);
		process.BillProcess(200.00D);
	}

}
