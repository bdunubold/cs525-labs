package edu.mum.cs.cs525.labs.skeleton.observer;

public interface Observer<E> {
	void update(E element, ObserverEventType eventType);
}
