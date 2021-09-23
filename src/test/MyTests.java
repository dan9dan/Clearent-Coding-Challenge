package test;

import org.junit.Test;

import challenge.*;

public class MyTests {
	
	@Test
	public void noWalletAndNoCards() {
		Person p = new Person();
		IWalletInterest w = new Wallet();
		
		assert(p.calculatePersonalSimpleInterest() == 0);
		assert(w.calculateWalletSimpleInterest() == 0);
		p.addWallet(w);
		assert(p.calculatePersonalSimpleInterest() == 0);
	}
	
	@Test
	public void noBalance() {
		CreditCard vc = new VisaCard();
		
		assert(vc.getBalance() == 0);
		assert(vc.calculateCardSimpleInterest() == 0);
	}
	
	@Test
	public void addingAndRemovingFromBalance() {
		CreditCard vc = new VisaCard(10000);
		CreditCard mc = new MasterCard(10000);
		CreditCard dc = new DiscoverCard(10000);
		
		assert(vc.getBalance() == 10000);
		assert(mc.getBalance() == 10000);
		assert(dc.getBalance() == 10000);
		assert(vc.calculateCardSimpleInterest() == 1000);
		assert(mc.calculateCardSimpleInterest() == 500);
		assert(dc.calculateCardSimpleInterest() == 100);
		
		vc.removeFromBalance(5000);
		assert(vc.getBalance() == 5000);
		assert(vc.calculateCardSimpleInterest() == 500);
		
		mc.addToBalance(12000);
		assert(mc.getBalance() == 22000);
		assert(mc.calculateCardSimpleInterest() == 1100);
		
		dc.addToBalance(-5000);
		dc.removeFromBalance(-3000);
		assert(dc.getBalance() == 10000);
		assert(dc.calculateCardSimpleInterest() == 100);
	}
	
	@Test
	public void changingInterestRates() {
		CreditCard vc = new VisaCard(10000);
		ICreditCardInterest mc = new MasterCard(10000);
		
		assert(vc.calculateCardSimpleInterest() == 1000);
		assert(mc.calculateCardSimpleInterest() == 500);
		
		VisaCard.setSimpleInterestRate(0.02f);
		assert(vc.calculateCardSimpleInterest() == 200);
		assert(mc.calculateCardSimpleInterest() == 500);
		vc.addToBalance(10000);
		assert(vc.calculateCardSimpleInterest() == 400);
		
		VisaCard.setSimpleInterestRate(-0.1f);
		assert(vc.calculateCardSimpleInterest() == 400);
		vc.removeFromBalance(10000);
		assert(vc.calculateCardSimpleInterest() == 200);
		assert(mc.calculateCardSimpleInterest() == 500);
		
		VisaCard.setSimpleInterestRate(0.1f);
		assert(vc.calculateCardSimpleInterest() == 1000);
		assert(mc.calculateCardSimpleInterest() == 500);
	}
}