package edu.mum.cs.cs525.labs.skeleton;

import java.util.Collection;

import edu.mum.cs.cs525.labs.skeleton.observer.Observable;

public interface AccountService extends Observable<Account> {
	
	void addInterest();
	
	Account createAccount(String accountNumber, String customerName);

	Account getAccount(String accountNumber);

	Collection<Account> getAllAccounts();

	void deposit(String accountNumber, double amount);

	void withdraw(String accountNumber, double amount);

	void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}
