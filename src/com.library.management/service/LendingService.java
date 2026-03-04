package com.library.management.service;

import com.library.management.repository.BookRepository;

import com.library.management.model.Patron;
import com.library.management.model.Book;

public class LendingService {

    private BookRepository bookRepository;

    public LendingService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean checkoutBook(String isbn, Patron patron) {

        Book book = bookRepository.getBook(isbn);

        if (book != null && book.isAvailable()) {

            book.setAvailable(false);
            patron.borrowBook(isbn);

            return true;
        }

        return false;
    }

    public void returnBook(String isbn, Patron patron) {

        Book book = bookRepository.getBook(isbn);

        if (book != null) {

            book.setAvailable(true);
            patron.returnBook(isbn);
        }
    }
}