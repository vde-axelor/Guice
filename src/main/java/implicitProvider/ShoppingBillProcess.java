package implicitProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ShoppingBillProcess {
	private final Provider<Discount> discount;
	@Inject
	public ShoppingBillProcess(Provider<Discount> discount) {
		this.discount=discount;
	}
	
	public double BillProcess(double shoppingCartTotal) {
		double disc=discount.get().getDiscount();
		double totalAfterDiscount=shoppingCartTotal-(shoppingCartTotal*disc);
		//interface implementation
		System.out.printf("%nShopping cart initially [$%.2f] with a discount of %.2f%% = [$%.2f]%n%n",shoppingCartTotal,disc*100,totalAfterDiscount);
		return totalAfterDiscount;
	}
}
