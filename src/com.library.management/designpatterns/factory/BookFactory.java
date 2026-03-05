package com.library.management.designpatterns.factory;
import com.library.management.model.Book;

public class BookFactory {

    // Factory method to create a Book object
    public static Book createBook(String title, String author, String isbn, int publicationYear) {

        return new Book(title, author, isbn, publicationYear);

    }
}