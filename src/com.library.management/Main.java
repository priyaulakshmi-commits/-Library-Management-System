

public class Main {

    public static void main(String[] args) {

        // Initialize services
        BookService bookService = new BookService();
        PatronService patronService = new PatronService();
        LibraryService libraryService = new LibraryService(bookService, patronService);

        // Create books using Factory Pattern
        Book book1 = BookFactory.createBook("Clean Code", "Robert Martin", "101", 2008);
        Book book2 = BookFactory.createBook("Effective Java", "Joshua Bloch", "102", 2018);

        // Add books to library
        bookService.addBook(book1);
        bookService.addBook(book2);

        LoggerUtil.logInfo("Books added to library");

        // Create patrons
        Patron patron1 = new Patron("P1", "Priya");
        Patron patron2 = new Patron("P2", "Rahul");

        patronService.addPatron(patron1);
        patronService.addPatron(patron2);

        LoggerUtil.logInfo("Patrons added");

        // Checkout book
        libraryService.checkoutBook("101", "P1");

        // Show borrowed books
        libraryService.showBorrowedBooks();

        // Return book
        libraryService.returnBook("101", "P1");

        LoggerUtil.logInfo("Book returned");

        // ---------- Observer Pattern Example ----------

        ReservationNotifier notifier = new ReservationNotifier();

        PatronObserver observer1 = new PatronObserver("Priya");
        PatronObserver observer2 = new PatronObserver("Rahul");

        notifier.addObserver(observer1);
        notifier.addObserver(observer2);

        notifier.notifyObservers("Book 'Clean Code' is now available!");

    }
}