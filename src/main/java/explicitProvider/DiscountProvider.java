package explicitProvider;

import com.google.inject.Provider;

public class DiscountProvider implements Provider<Discount>{
	@Override
	public Discount get() {
		return new  DiscountByCard();
	}
}
