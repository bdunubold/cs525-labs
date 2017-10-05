package edu.mum.cs.cs525.labs.skeleton;

import java.util.ArrayList;
import java.util.Collection;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public class Account {
	private InterestStrategy interestStrategy;
	
	private Customer customer;

	private String accountNumber;

	private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void addInterest() {
		if(null == interestStrategy) {
			return; // do nothing
		}
		
		double interest = interestStrategy.computeInterest(getBalance());
		
		AccountEntry entry = new AccountEntry(interest, "interest", "", "");
		entryList.add(entry);
	}

	public InterestStrategy getInterestStrategy() {
		return interestStrategy;
	}

	public void setInterestStrategy(InterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());

		entryList.add(fromEntry);

		toAccount.addEntry(toEntry);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	@Override
	public String toString() {
		return "Account [interestStrategy=" + interestStrategy + ", customer=" + customer + ", accountNumber="
				+ accountNumber + "]";
	}

}
