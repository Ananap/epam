package com.panasenko.shape.observer;

public interface TriangleObservable {
    void attach(TriangleObserver observer);
    void detach(TriangleObserver observer);
    void notifyObservers();
}
