package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class EmailSender implements Observer<Account> {

	@Override
	public void update(Account account, ObserverEventType eventType) {
		if(ObserverEventType.ENTITY_CREATION == eventType) {
			System.out.println("Sending email regarding account: " + account);
		}
	}

}
