package com.library.management.model;
import java.time.LocalDate;

public class Loan {

    private Book book;
    private Patron patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = LocalDate.now();
        this.returned = false;
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
        this.returned = true;
    }
}