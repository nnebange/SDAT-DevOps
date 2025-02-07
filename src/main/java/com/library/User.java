package com.library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;
    private static final int BORROWING_LIMIT = 5; // Set a default limit

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks); // Return a copy to prevent external modification
    }

    public boolean borrowBook(Book book) {
        if (book.isAvailable() && borrowedBooks.size() < BORROWING_LIMIT) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    public int getRemainingBorrowingLimit() {
        return BORROWING_LIMIT - borrowedBooks.size();
    }
}
