package com.library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;
    private int borrowingLimit;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.borrowingLimit = 5; // default borrowing limit
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && borrowedBooks.size() < borrowingLimit) {
            borrowedBooks.add(book);
            book.setAvailable(false);
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
        }
    }

    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }
}
