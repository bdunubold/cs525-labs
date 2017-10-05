package edu.mum.cs.cs525.labs.skeleton.strategy;

public class InterestStrategyChecking implements InterestStrategy {

	@Override
	public double computeInterest(double balance) {
		if(balance < 1000.0) {
			return 0.01 * balance;
		} else if(balance > 5000.0) {
			return 0.04 * balance;
		} else {
			return 0.02 * balance;
		}		
	}

}
