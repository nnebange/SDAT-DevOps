package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalog;
    private List<User> users;

    public Library() {
        this.catalog = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book searchBook(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean issueBook(String title, User user) {
        Book book = searchBook(title);
        if (book != null && book.isAvailable()) {
            return user.borrowBook(book);
        }
        return false;
    }

    public void returnBook(String title, User user) {
        Book book = searchBook(title);
        if (book != null) {
            user.returnBook(book);
        }
    }

    public List<Book> getCatalog() {
        return catalog;
    }
}
