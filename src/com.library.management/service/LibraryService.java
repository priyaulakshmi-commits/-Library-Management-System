package com.library.management.service;

import com.library.management.model.Book;
import com.library.management.model.Patron;
import com.library.management.model.Loan;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private BookService bookService;
    private PatronService patronService;
    private List<Loan> loans;

    public LibraryService(BookService bookService, PatronService patronService) {
        this.bookService = bookService;
        this.patronService = patronService;
        this.loans = new ArrayList<>();
    }

    // Checkout book
    public void checkoutBook(String isbn, String patronId) {

        Book book = bookService.searchByISBN(isbn);
        Patron patron = patronService.getPatron(patronId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (patron == null) {
            System.out.println("Patron not found");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed");
            return;
        }

        Loan loan = new Loan(book, patron);

        loans.add(loan);
        book.setAvailable(false);
        patron.borrowBook(isbn);

        System.out.println("Book checked out successfully");
    }

    // Return book
    public void returnBook(String isbn, String patronId) {

        for (Loan loan : loans) {

            if (loan.getBook().getIsbn().equals(isbn)
                    && loan.getPatron().getPatronId().equals(patronId)
                    && !loan.isReturned()) {

                loan.returnBook();
                loan.getBook().setAvailable(true);
                loan.getPatron().returnBook(isbn);

                System.out.println("Book returned successfully");
                return;
            }
        }

        System.out.println("Loan record not found");
    }

    // Show all borrowed books
    public void showBorrowedBooks() {

        for (Loan loan : loans) {

            if (!loan.isReturned()) {

                System.out.println(
                        loan.getBook().getTitle()
                                + " borrowed by "
                                + loan.getPatron().getName()
                );
            }
        }
    }

    // Show loan history
    public List<Loan> getLoanHistory() {
        return loans;
    }
}