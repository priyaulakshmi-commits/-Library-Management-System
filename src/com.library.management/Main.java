
package com.library.management;

import com.library.management.model.Book;
import com.library.management.model.Patron;

import com.library.management.service.BookService;
import com.library.management.service.PatronService;
import com.library.management.service.LibraryService;
import com.library.management.service.LendingService;

import com.library.management.repository.BookRepository;
import com.library.management.repository.PatronRepository;

import com.library.management.designpatterns.factory.BookFactory;

import com.library.management.designpatterns.observer.PatronObserver;
import com.library.management.designpatterns.observer.ReservationNotifier;

import com.library.management.util.LoggerUtil;

public class Main {

    public static void main(String[] args) {

        // Initialize repositories
        BookRepository bookRepository = new BookRepository();
        PatronRepository patronRepository = new PatronRepository();

        // Initialize services
        BookService bookService = new BookService(bookRepository);
        PatronService patronService = new PatronService(patronRepository);

        LibraryService libraryService = new LibraryService(bookService, patronService);

        LoggerUtil.logInfo("Library Management System Started");

        // Create books using Factory Pattern
        Book book1 = BookFactory.createBook("Clean Code", "Robert Martin", "ISBN101", 2008);
        Book book2 = BookFactory.createBook("Effective Java", "Joshua Bloch", "ISBN102", 2018);

        bookService.addBook(book1);
        bookService.addBook(book2);

        // Create patrons
        Patron patron1 = new Patron("P1", "Priya");
        Patron patron2 = new Patron("P2", "Rahul");

        patronService.addPatron(patron1);
        patronService.addPatron(patron2);

        // Checkout book
        libraryService.checkoutBook("ISBN101", "P1");

        // Return book
        libraryService.returnBook("ISBN101", "P1");

        // -------- Observer Pattern Demo --------

        ReservationNotifier notifier = new ReservationNotifier();

        PatronObserver observer1 = new PatronObserver("Priya");
        PatronObserver observer2 = new PatronObserver("Rahul");

        notifier.addObserver(observer1);
        notifier.addObserver(observer2);

        notifier.notifyObservers("Book 'Clean Code' is now available.");

        LoggerUtil.logInfo("Library Management System Finished");

    }
}