package edu.mum.cs.cs525.labs.skeleton.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable<E> implements Observable<E> {
	
	private List<Observer<E>> observers = new ArrayList<>();
	
	@Override
	public void notifyAllObservers(E element, ObserverEventType eventType) {
		for(Observer<E> observer : observers) {
			observer.update(element, eventType);
		}
	}
	
	@Override
	public void addObserver(Observer<E> observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(Observer<E> observer) {
		observers.remove(observer);
	}
}
