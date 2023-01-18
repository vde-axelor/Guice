package com.guice;

import com.google.inject.Inject;

public class ShoppingBillProcess {
	private final Discount discount;
	@Inject
	public ShoppingBillProcess(Discount discount) {
		this.discount=discount;
	}
	
	public double BillProcess(double shoppingCartTotal) {
		double totalAfterDiscount=shoppingCartTotal-(shoppingCartTotal*discount.getDiscount());
		//interface implementation
		System.out.printf("%nShopping cart initially [$%.2f] with a discount of %.2f%% = [$%.2f]%n%n",shoppingCartTotal,discount.getDiscount()*100,totalAfterDiscount);
		return totalAfterDiscount;
	}
}
