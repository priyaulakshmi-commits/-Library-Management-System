package com.library.management.designpatterns.observer;
public class PatronObserver implements Observer {

    private String patronName;

    public PatronObserver(String patronName) {
        this.patronName = patronName;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + patronName + ": " + message);
    }
}