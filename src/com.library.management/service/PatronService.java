package com.library.management.service;
import java.util.*;

public class PatronService {

    private Map<String, Patron> patrons;

    public PatronService() {
        patrons = new HashMap<>();
    }

    // Add new patron
    public void addPatron(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
        System.out.println("Patron added: " + patron.getName());
    }

    // Update patron name
    public void updatePatron(String patronId, String newName) {

        Patron patron = patrons.get(patronId);

        if (patron != null) {
            patron.setName(newName);
            System.out.println("Patron updated successfully");
        } else {
            System.out.println("Patron not found");
        }
    }

    // Get patron
    public Patron getPatron(String patronId) {
        return patrons.get(patronId);
    }

    // Show borrowing history
    public void showBorrowHistory(String patronId) {

        Patron patron = patrons.get(patronId);

        if (patron != null) {
            System.out.println("Borrow History: " + patron.getBorrowHistory());
        } else {
            System.out.println("Patron not found");
        }
    }

    // Get all patrons
    public Collection<Patron> getAllPatrons() {
        return patrons.values();
    }
}