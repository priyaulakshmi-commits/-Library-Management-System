package com.library.management.service;

import com.library.management.model.Book;
import com.library.management.repository.BookRepository;

import java.util.*;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();

        for (Book book : repository.getAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }

        return result;
    }

    public Book searchByISBN(String isbn) {
        return repository.getBook(isbn);
    }
}