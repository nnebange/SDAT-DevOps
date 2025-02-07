
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
            if (book.getTitle().contains(query) || book.getAuthor().contains(query)) {
                results.add(book);
            }
        }
        return results;
    }

    public void issueBook(User user, Book book) {
        if (book.isAvailable() && user.getBorrowingLimit() > 0) {
            book.setAvailable(false);
            user.borrowBook(book);
        }
    }

    public void returnBook(User user, Book book) {
        if (!book.isAvailable() && user.hasBorrowedBook(book)) {
            book.setAvailable(true);
            user.returnBook(book);
        }
    }
}
