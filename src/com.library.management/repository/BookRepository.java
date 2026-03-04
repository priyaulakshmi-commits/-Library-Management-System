package com.library.management.repository;


import com.library.management.model.Book;

import java.util.*;

public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}