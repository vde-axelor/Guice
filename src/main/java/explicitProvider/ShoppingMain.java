package explicitProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ShoppingMain {

	public static void main(String[] args) {
		Injector guice=Guice.createInjector(new DiscountModule());
		ShoppingBillProcess process=guice.getInstance(ShoppingBillProcess.class);
		System.out.println("Explict Provider calling..");
		process.BillProcess(150.00D);
	}

}
