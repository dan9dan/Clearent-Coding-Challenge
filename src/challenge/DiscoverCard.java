package challenge;

public class DiscoverCard extends CreditCard {
	private static float simpleInterestRate = 0.01f;
	
	public DiscoverCard() {
		super();
	}
	
	public DiscoverCard(int amount) {
		super(amount);
	}

	public int calculateCardSimpleInterest() {
		return Math.round(this.getBalance() * simpleInterestRate);
	}
	
	public static void setSimpleInterestRate(float rate) {
		if (rate >= 0) {
			simpleInterestRate = rate;
		}
	}
}
