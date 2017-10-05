package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.observer.EmailSender;
import edu.mum.cs.cs525.labs.skeleton.observer.Logger;
import edu.mum.cs.cs525.labs.skeleton.observer.SMSSender;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategyChecking;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategySavings;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();
		
		accountService.addObserver(new EmailSender());
		accountService.addObserver(new SMSSender());
		accountService.addObserver(new Logger());

		// create 2 accounts;
		Account account1 = accountService.createAccount("1263862", "Frank Brown");
		account1.setInterestStrategy(new InterestStrategyChecking());
		
		Account account2 = accountService.createAccount("4253892", "John Doe");
		account2.setInterestStrategy(new InterestStrategySavings());
		
		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);
		
		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		
		// add interest
		accountService.addInterest();
		
		// show balances
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());

			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");

			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}

			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
