package com.library.management.model;
import java.util.*;

public class Patron {

    private String patronId;
    private String name;
    private List<String> borrowedBooks;

    public Patron(String patronId, String name) {
        this.patronId = patronId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getPatronId() {
        return patronId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }

    public List<String> getBorrowHistory() {
        return borrowedBooks;
    }
}