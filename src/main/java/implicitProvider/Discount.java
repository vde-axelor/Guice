package implicitProvider;

import com.google.inject.ImplementedBy;

@ImplementedBy(DiscountByCard.class)
public interface Discount {
	double getDiscount();
}
