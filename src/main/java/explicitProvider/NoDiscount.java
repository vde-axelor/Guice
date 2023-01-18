package explicitProvider;

public class NoDiscount implements Discount{
	@Override
	public double getDiscount() {
		return(0.0);
	}
}
