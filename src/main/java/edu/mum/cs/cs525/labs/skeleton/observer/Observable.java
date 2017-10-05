package edu.mum.cs.cs525.labs.skeleton.observer;

public interface Observable<E> {

	void notifyAllObservers(E element, ObserverEventType eventType);

	void addObserver(Observer<E> observer);

	void removeObserver(Observer<E> observer);

}