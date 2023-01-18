package implicitProvider;
import explicitProvider.DiscountModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ShoppingMain {

	public static void main(String[] args) {
		Injector guice=Guice.createInjector(new DiscountModule());
		ShoppingBillProcess process=guice.getInstance(ShoppingBillProcess.class);
		System.out.println("Implicit Provider calling..");
		process.BillProcess(200.00D);
		
	}

}
