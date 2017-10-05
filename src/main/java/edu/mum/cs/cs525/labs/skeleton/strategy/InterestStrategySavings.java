package edu.mum.cs.cs525.labs.skeleton.strategy;

public class InterestStrategySavings implements InterestStrategy {

	@Override
	public double computeInterest(double balance) {		
		if(balance < 1000.0) {
			return 0.015 * balance;
		} else {
			return 0.025 * balance;
		}		
	}

}
