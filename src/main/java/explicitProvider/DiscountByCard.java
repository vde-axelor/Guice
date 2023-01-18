package explicitProvider;

public class DiscountByCard implements Discount{
	@Override
	public double getDiscount() {
		return(0.25);
	}

}
