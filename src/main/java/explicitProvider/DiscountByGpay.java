package explicitProvider;

public class DiscountByGpay implements Discount{
	@Override
	public double getDiscount() {
		return(0.15);
	}

}
