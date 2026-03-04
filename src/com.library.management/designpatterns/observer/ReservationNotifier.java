package com.library.management.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ReservationNotifier {

    private List<Observer> observers;

    public ReservationNotifier() {
        observers = new ArrayList<>();
    }

    // Add observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers
    public void notifyObservers(String message) {

        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}