package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class SMSSender implements Observer<Account> {

	@Override
	public void update(Account account, ObserverEventType eventType) {
		if(ObserverEventType.ENTITY_UPDATE == eventType) {
			System.out.println("Sending SMS regarding account: " + account);
		}
	}

}
