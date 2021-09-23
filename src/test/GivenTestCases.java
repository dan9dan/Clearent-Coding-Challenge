package test;

import org.junit.Test;

import challenge.*;

public class GivenTestCases {
	
	@Test
	public void testCase1() {
		Person p = new Person();
		Wallet w = new Wallet();
		ICreditCardInterest vc = new VisaCard(10000);
		ICreditCardInterest mc = new MasterCard(10000);
		ICreditCardInterest dc = new DiscoverCard(10000);
		
		w.addCard(vc);
		w.addCard(mc);
		w.addCard(dc);
		p.addWallet(w);
		
		assert(p.calculatePersonalSimpleInterest() == 1600);
		
		assert(vc.calculateCardSimpleInterest() == 1000);
		assert(mc.calculateCardSimpleInterest() == 500);
		assert(dc.calculateCardSimpleInterest() == 100);
	}
	
	@Test
	public void testCase2() {
		Person p = new Person();
		Wallet w1 = new Wallet();
		Wallet w2 = new Wallet();
		ICreditCardInterest vc = new VisaCard(10000);
		ICreditCardInterest dc = new DiscoverCard(10000);
		ICreditCardInterest mc = new MasterCard(10000);
		
		w1.addCard(vc);
		w1.addCard(dc);
		w2.addCard(mc);
		p.addWallet(w1);
		p.addWallet(w2);
		
		assert(p.calculatePersonalSimpleInterest() == 1600);
		
		assert(w1.calculateWalletSimpleInterest() == 1100);
		assert(w2.calculateWalletSimpleInterest() == 500);
	}
	
	@Test
	public void testCase3() {
		Person p1 = new Person();
		Person p2 = new Person();
		Wallet w1 = new Wallet();
		Wallet w2 = new Wallet();
		ICreditCardInterest mc1 = new MasterCard(10000);
		ICreditCardInterest mc2 = new MasterCard(10000);
		ICreditCardInterest mc3 = new MasterCard(10000);
		ICreditCardInterest vc = new VisaCard(10000);
		
		w1.addCard(mc1);
		w1.addCard(mc2);
		p1.addWallet(w1);
		w2.addCard(mc3);
		w2.addCard(vc);
		p2.addWallet(w2);
		
		assert(p1.calculatePersonalSimpleInterest() == 1000);
		assert(w1.calculateWalletSimpleInterest() == 1000);
		assert(p2.calculatePersonalSimpleInterest() == 1500);
		assert(w2.calculateWalletSimpleInterest() == 1500);
		}
}