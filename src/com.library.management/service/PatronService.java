
package com.library.management.service;

import com.library.management.model.Patron;
import com.library.management.repository.PatronRepository;

import java.util.Collection;

public class PatronService {

    private PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    // Add patron
    public void addPatron(Patron patron) {
        patronRepository.addPatron(patron);
        System.out.println("Patron added: " + patron.getName());
    }

    // Get patron
    public Patron getPatron(String patronId) {
        return patronRepository.getPatronById(patronId);
    }

    // Update patron
    public void updatePatron(String patronId, String newName) {

        Patron patron = patronRepository.getPatronById(patronId);

        if (patron != null) {
            patron.setName(newName);
            patronRepository.updatePatron(patron);
            System.out.println("Patron updated successfully");
        } else {
            System.out.println("Patron not found");
        }
    }

    // Get all patrons
    public Collection<Patron> getAllPatrons() {
        return patronRepository.getAllPatrons();
    }
}