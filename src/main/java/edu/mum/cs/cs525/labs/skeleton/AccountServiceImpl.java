package edu.mum.cs.cs525.labs.skeleton;

import java.util.Collection;

import edu.mum.cs.cs525.labs.skeleton.observer.AbstractObservable;
import edu.mum.cs.cs525.labs.skeleton.observer.ObserverEventType;

public class AccountServiceImpl extends AbstractObservable<Account> implements AccountService {
	
	private AccountDAO accountDAO;

	public AccountServiceImpl() {
		accountDAO = new AccountDAOImpl();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

		accountDAO.saveAccount(account);
		
		notifyAllObservers(account, ObserverEventType.ENTITY_CREATION);

		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);

		accountDAO.updateAccount(account);
		
		notifyAllObservers(account, ObserverEventType.ENTITY_UPDATE);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);

		notifyAllObservers(account, ObserverEventType.ENTITY_UPDATE);
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		
		notifyAllObservers(fromAccount, ObserverEventType.ENTITY_UPDATE);
		notifyAllObservers(toAccount, ObserverEventType.ENTITY_UPDATE);
	}

	@Override
	public void addInterest() {
		for(Account account : getAllAccounts()) {
			account.addInterest();
			
			notifyAllObservers(account, ObserverEventType.ENTITY_UPDATE);
		}		
	}
}
