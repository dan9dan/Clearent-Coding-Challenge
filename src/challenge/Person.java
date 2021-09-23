package challenge;

import java.util.ArrayList;
import java.util.Iterator;

/* By using an interface to interact with the wallets, 
 * I adhere to the Dependency Inversion Principle
 */

public class Person {
	private ArrayList<IWalletInterest> wallets;
	
	public Person() {
		wallets = new ArrayList<IWalletInterest>();
	}
	
	public void addWallet(IWalletInterest w) {
		wallets.add(w);
	}
	
	public int calculatePersonalSimpleInterest() {
		int sum = 0;
		for (IWalletInterest wallet : wallets) {
			sum += wallet.calculateWalletSimpleInterest();
		}
		return sum;
	}
}
