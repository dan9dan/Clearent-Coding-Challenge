package challenge;

/* The purpose of having a CreditCard superclass and specific card type 
 * subclasses was to try and adhere to the Single Responsibility Principle. 
 * The superclass handles the balance, and the subclasses handle the interest 
 * rate and how its calculated. Additionally, if there was going to be variance 
 * between how the card companies wanted to calculate interest in the future,  
 * only their specific class has to be altered. 
 * I was considering making this just an interface, but also thought that these basic
 * accessor and mutators wouldn't need to change in the future while still atomic enough
 * to allow flexible use, adhering to the Open/Closed Principle. I might be wrong about
 * that however, it may be more appropriate as an interface.
 * Because the class is abstract, the base class cannot be used on its own. 
 * By my understanding, that means the Liskov Substitution Principle does not apply.  
 */

public abstract class CreditCard implements ICreditCardInterest{
	private int balance;
	
	public CreditCard() {
		balance = 0;
	}
	
	public CreditCard(int amount) {
		balance = amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	/* For the following two methods, based on my understanding, we want to
	 * be explicit if a transaction is a debit or a credit, which will determine
	 * which method is called. Because of that, we don't want a debit or credit
	 * having the opposite effect of what it should do, hence the checking for 
	 * nonnegative value.
	 */
	public boolean addToBalance(int amount) {
		if (amount >= 0) {
			balance += amount;
			return true;
		}
		return false;
	}
	
	public boolean removeFromBalance(int amount) {
		if (amount >= 0) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
}