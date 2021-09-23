package challenge;

public class MasterCard extends CreditCard {
	private static float simpleInterestRate = 0.05f;
	
	public MasterCard() {
		super();
	}
	
	public MasterCard(int amount) {
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
