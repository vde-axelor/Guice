package explicitProvider;

import javax.inject.Provider;

import com.google.inject.AbstractModule;

public class DiscountModule extends AbstractModule{
	//Explicit Bind
	protected void configure() {
		bind(Discount.class).toProvider((Class<? extends Provider<? extends Discount>>) DiscountProvider.class);
	}

}
