# Library-Management-System

                    +------------------+
                    |       Book       |
                    +------------------+
                    | title            |
                    | author           |
                    | isbn             |
                    | publicationYear  |
                    | available        |
                    +------------------+
                            ▲
                            |
                            |
                    +------------------+
                    |       Loan       |
                    +------------------+
                    | borrowDate       |
                    | returnDate       |
                    | returned         |
                    +------------------+
                            |
                            |
                            ▼
                    +------------------+
                    |      Patron      |
                    +------------------+
                    | patronId         |
                    | name             |
                    | borrowedBooks    |
                    +------------------+



+----------------------+        +-----------------------+
|    BookRepository    |        |    PatronRepository   |
+----------------------+        +-----------------------+
| Map<String, Book>    |        | Map<String, Patron>   |
+----------------------+        +-----------------------+
            ▲                               ▲
            | uses                          | uses
            |                               |
+----------------------+        +-----------------------+
|      BookService     |        |     PatronService     |
+----------------------+        +-----------------------+
| addBook()            |        | addPatron()           |
| searchByTitle()      |        | updatePatron()        |
| searchByISBN()       |        | getPatron()           |
+----------------------+        +-----------------------+


                +----------------------+
                |    LendingService    |
                +----------------------+
                | checkoutBook()       |
                | returnBook()         |
                +----------------------+
                       ▲
                       |
                       | manages
                       |
                +----------------------+
                |     LibraryService   |
                +----------------------+
                | showBorrowedBooks()  |
                | getLoanHistory()     |
                +----------------------+



             +--------------------+
             |     BookFactory    |
             +--------------------+
             | createBook()       |
             +--------------------+
                      |
                      | creates
                      ▼
                    Book



            +--------------------+
            |      Observer      |
            +--------------------+
            | update()           |
            +--------------------+
                     ▲
                     |
            +----------------------+
            |    PatronObserver    |
            +----------------------+
            | update()             |
            +----------------------+

                     ▲
                     |
            +----------------------+
            | ReservationNotifier  |
            +----------------------+
            | addObserver()        |
            | notifyObservers()    |
            +----------------------+



            +----------------------+
            |      LoggerUtil      |
            +----------------------+
            | logInfo()            |
            | logWarning()         |
            | logError()           |
            +----------------------+
