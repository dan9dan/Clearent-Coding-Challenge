package challenge;

public class VisaCard extends CreditCard {
	private static float simpleInterestRate = 0.1f;
	
	public VisaCard() {
		super();
	}
	
	public VisaCard(int amount) {
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
