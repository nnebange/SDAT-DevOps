package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalog;
    private List<User> users;

    public Library() {
        catalog = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void removeBook(Book book) {
        catalog.remove(book);
    }

    public List<Book> searchCatalog(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) || 
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean issueBook(User user, Book book) {
        if (catalog.contains(book) && book.isAvailable() && user.borrowBook(book)) {
            return true;
        }
        return false;
    }

    public boolean returnBook(User user, Book book) {
        if (catalog.contains(book) && user.hasBorrowedBook(book)) {
            return user.returnBook(book);
        }
        return false;
    }
}
