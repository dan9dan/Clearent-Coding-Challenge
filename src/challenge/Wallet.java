package challenge;

import java.util.ArrayList;

/* By using an interface to interact with the credit cards, 
 * I adhere to the Dependency Inversion Principle
 */

public class Wallet implements IWalletInterest {
	private ArrayList<ICreditCardInterest> cards;
	
	public Wallet() {
		cards = new ArrayList<ICreditCardInterest>();
	}
	
	public void addCard(ICreditCardInterest card) {
		cards.add(card);
	}
	
	public int calculateWalletSimpleInterest() {
		int sum = 0;
		for (ICreditCardInterest card : cards) {
			sum += card.calculateCardSimpleInterest();
		}
		return sum;
	}
}
