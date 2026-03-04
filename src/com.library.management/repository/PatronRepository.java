package com.library.management.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PatronRepository {

    private Map<String, Patron> patrons;

    public PatronRepository() {
        patrons = new HashMap<>();
    }

    // Add a new patron
    public void addPatron(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
    }

    // Get patron by ID
    public Patron getPatronById(String patronId) {
        return patrons.get(patronId);
    }

    // Update patron
    public void updatePatron(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
    }

    // Remove patron
    public void removePatron(String patronId) {
        patrons.remove(patronId);
    }

    // Get all patrons
    public Collection<Patron> getAllPatrons() {
        return patrons.values();
    }

    // Check if patron exists
    public boolean exists(String patronId) {
        return patrons.containsKey(patronId);
    }
}